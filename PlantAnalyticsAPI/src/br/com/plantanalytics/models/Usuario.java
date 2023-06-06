package br.com.plantanalytics.models;

public class Usuario{
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	private int id;
    private String user;
    private String senha;
	public Usuario(int id, String user, String senha) {
		super();
		this.id = id;
		this.user = user;
		this.senha = senha;
	}

}