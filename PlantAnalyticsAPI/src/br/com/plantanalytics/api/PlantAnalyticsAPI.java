package br.com.plantanalytics.api;

import br.com.plantanalytics.dao.AnaliseDAO;
import com.plantanalytics.dao.UsuarioDAO;
import com.plantanalytics.models.Analise;
import com.plantanalytics.models.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/plantanalytics")
public class PlantAnalyticsAPI {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private AnaliseDAO analiseDAO = new AnaliseDAO();

    // Endpoint para realizar o login
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Usuario usuario) {
        // Lógica de autenticação
        // Verifique se o usuário existe e a senha está correta

        // Exemplo simples de autenticação
        for (Usuario u : usuarioDAO.getAllUsuarios()) {
            if (u.getUser().equals(usuario.getUser()) && u.getSenha().equals(usuario.getSenha())) {
                return Response.ok().build();
            }
        }

        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    // Endpoint para obter todos os usuários
    @GET
    @Path("/usuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> obterUsuarios() {
        return usuarioDAO.getAllUsuarios();
    }

    // Endpoint para obter um usuário pelo ID
    @GET
    @Path("/usuarios/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario obterUsuarioPorId(@PathParam("id") int id) {
        return usuarioDAO.getUsuarioById(id);
    }

    // Endpoint para criar um novo usuário
    @POST
    @Path("/usuarios")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario criarUsuario(Usuario usuario) {
        return usuarioDAO.createUsuario(usuario);
    }

    // Endpoint para atualizar um usuário existente
    @PUT
    @Path("/usuarios/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario atualizarUsuario(@PathParam("id") int id, Usuario usuario) {
        usuario.setId(id);
        return usuarioDAO.updateUsuario(usuario);
    }

    // Endpoint para excluir um usuário pelo ID
    @DELETE
    @Path("/usuarios/{id}")
    public Response excluirUsuario(@PathParam("id") int id) {
        if (usuarioDAO.deleteUsuario(id)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // Endpoint para obter todas as análises
    @GET
    @Path("/analises")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Analise> obterAnalises() {
        return analiseDAO.getAllAnalises();
    }

    // Endpoint para obter uma análise pelo ID
    @GET
    @Path("/analises/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Analise obterAnalisePorId(@PathParam("id") int id) {
        return analiseDAO.getAnaliseById(id);
    }

    // Endpoint para criar uma nova análise
    @POST
    @Path("/analises")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Analise criarAnalise(Analise analise) {
        return analiseDAO.createAnalise(analise);
    }

    // Endpoint para atualizar uma análise existente
    @PUT
    @Path("/analises/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Analise atualizarAnalise(@PathParam("id") int id, Analise analise) {
        analise.setId(id);
        return analiseDAO.updateAnalise(analise);
    }

    // Endpoint para excluir uma análise pelo ID
    @DELETE
    @Path("/analises/{id}")
    public Response excluirAnalise(@PathParam("id") int id) {
        if (analiseDAO.deleteAnalise(id)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
