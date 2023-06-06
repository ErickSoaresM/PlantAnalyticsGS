package br.com.plantanalytics.models;

import java.util.Date;

public class Analise {
    private int id;
    private String resultado;
    private String doenca;
    private Date dataEnvio;
    private String tipoPlanta;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String getDoenca() {
		return doenca;
	}
	public void setDoenca(String doenca) {
		this.doenca = doenca;
	}
	public Date getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	public String getTipoPlanta() {
		return tipoPlanta;
	}
	public void setTipoPlanta(String tipoPlanta) {
		this.tipoPlanta = tipoPlanta;
	}
	public Analise(int id, String resultado, String doenca, Date dataEnvio, String tipoPlanta) {
		super();
		this.id = id;
		this.resultado = resultado;
		this.doenca = doenca;
		this.dataEnvio = dataEnvio;
		this.tipoPlanta = tipoPlanta;
	}

}