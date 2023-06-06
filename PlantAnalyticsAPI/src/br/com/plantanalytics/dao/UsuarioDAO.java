package br.com.plantanalytics.dao;

import br.com.plantanalytics.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private List<Usuario> usuarios = new ArrayList<>();
    private int nextId = 1;

    public UsuarioDAO() {
        Usuario usuario = new Usuario(nextId, null, null);
        usuario.setId(nextId++);
        usuario.setUser("admin");
        usuario.setSenha("admin123");

        usuarios.add(usuario);
    }

    public List<Usuario> getAllUsuarios() {
        return usuarios;
    }

    public Usuario getUsuarioById(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario createUsuario(Usuario usuario) {
        usuario.setId(nextId++);
        usuarios.add(usuario);
        return usuario;
    }

    public Usuario updateUsuario(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == usuario.getId()) {
                usuarios.set(i, usuario);
                return usuario;
            }
        }
        return null;
    }

    public boolean deleteUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                usuarios.remove(usuario);
                return true;
            }
        }
        return false;
    }
}
