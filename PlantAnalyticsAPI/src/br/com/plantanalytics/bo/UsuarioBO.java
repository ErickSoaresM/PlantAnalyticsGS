package br.com.plantanalytics.bo;

import br.com.plantanalytics.dao.UsuarioDAO;
import br.com.plantanalytics.models.Usuario;

import java.util.List;

public class UsuarioBO {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public List<Usuario> getAllUsuarios() {
        return usuarioDAO.getAllUsuarios();
    }

    public Usuario getUsuarioById(int id) {
        return usuarioDAO.getUsuarioById(id);
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuarioDAO.createUsuario(usuario);
    }

    public Usuario updateUsuario(Usuario usuario) {
        return usuarioDAO.updateUsuario(usuario);
    }

    public boolean deleteUsuario(int id) {
        return usuarioDAO.deleteUsuario(id);
    }
}
