package br.com.plantanalytics.view;

import br.com.plantanalytics.bo.UsuarioBO;
import br.com.plantanalytics.models.Usuario;

import java.util.List;

public class UsuarioView {
    private UsuarioBO usuarioBO = new UsuarioBO();

    public List<Usuario> getAllUsuarios() {
        return usuarioBO.getAllUsuarios();
    }

    public Usuario getUsuarioById(int id) {
        return usuarioBO.getUsuarioById(id);
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuarioBO.createUsuario(usuario);
    }

    public Usuario updateUsuario(int id, Usuario usuario) {
        usuario.setId(id);
        return usuarioBO.updateUsuario(usuario);
    }

    public boolean deleteUsuario(int id) {
        return usuarioBO.deleteUsuario(id);
    }
}
