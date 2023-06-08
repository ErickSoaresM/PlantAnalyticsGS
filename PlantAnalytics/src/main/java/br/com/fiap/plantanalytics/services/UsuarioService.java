package br.com.fiap.plantanalytics.services;


import br.com.fiap.plantanalytics.dtos.*;
import br.com.fiap.plantanalytics.exceptions.RestNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fiap.plantanalytics.models.Usuario;
import br.com.fiap.plantanalytics.repositories.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	private UsuarioRepository repository;
	private AuthenticationManager manager;
	private PasswordEncoder encoder;
	private TokenService tokenService;

	@Autowired
	public UsuarioService(UsuarioRepository repository, AuthenticationManager manager, PasswordEncoder encoder, TokenService tokenService) {
		this.repository = repository;
		this.manager = manager;
		this.encoder = encoder;
		this.tokenService = tokenService;
	}

	public Usuario cadastrar(Usuario usuario)
    {
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		repository.save(usuario);

		return repository.save(usuario);
    }

	public UsuarioResponseDTO atualizar(UsuarioUpdateDTO usuario, long id) {
		Usuario repositoryResponse = repository
				.findById(id)
				.orElseThrow(() -> new RestNotFoundException("Usuario não encontrado"));

		boolean isUpdatable = false;

		if(usuario.usuario() != null && !usuario.usuario().equals(repositoryResponse.getUsuario())) {
			isUpdatable = repositoryResponse.setUsuario(usuario.usuario());
		}

		if(usuario.email() != null && !usuario.email().equals(repositoryResponse.getEmail())) {
			isUpdatable = repositoryResponse.setEmail(usuario.email());
		}

		if(usuario.senha() != null && !usuario.senha().equals(repositoryResponse.getSenha())) {
			isUpdatable = repositoryResponse.setSenha(usuario.senha());
		}

		if(isUpdatable) {
			var respostaAtualizacao = atualizarUsuario(repositoryResponse);

			return new UsuarioResponseDTO(
					respostaAtualizacao.getId(),
					respostaAtualizacao.getUsuario(),
					respostaAtualizacao.getEmail(),
					respostaAtualizacao.getSenha()
			);
		}

		return null;
	}

	public Usuario recuperar(long id) {

		Usuario usuario = repository
				.findById(id)
				.orElseThrow(() -> new RestNotFoundException("Usuario não encontrado"));

		return usuario;
	}

	public TokenDTO logar(LoginDTO credenciais) {
		manager.authenticate(credenciais.toAuthentication());

		return tokenService.generateToken(credenciais);
	}

	private Usuario atualizarUsuario(Usuario usuario)
    {
		return repository.saveAndFlush(usuario);
    }
}
