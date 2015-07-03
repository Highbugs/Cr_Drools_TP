package com.sample.model;

public class Estudante extends Pessoa {
	private int anoEscolaridade;
	private float mediaCurso;
	private boolean creditosIguais;
	private boolean matriculadoUniversidade;
	private Cliente fiador; 

	public Estudante(String nome, int idade, boolean historicoIncumprimento,
			int anoEscolaridade, float mediaCurso, boolean creditosIguais,
			boolean matriculadoUniversidade) {
		super(nome, idade, historicoIncumprimento);
		this.anoEscolaridade = anoEscolaridade;
		this.mediaCurso = mediaCurso;
		this.creditosIguais = creditosIguais;
		this.matriculadoUniversidade = matriculadoUniversidade;
	}
	
	public Cliente getFiador() {
		return fiador;
	}

	public void setFiador(Cliente fiador) {
		this.fiador = fiador;
	}

	public int getAnoEscolaridade() {
		return anoEscolaridade;
	}
	public void setAnoEscolaridade(int anoEscolaridade) {
		this.anoEscolaridade = anoEscolaridade;
	}
	public float getMediaCurso() {
		return mediaCurso;
	}
	public void setMediaCurso(float mediaCurso) {
		this.mediaCurso = mediaCurso;
	}
	public boolean isCreditosIguais() {
		return creditosIguais;
	}
	public void setCreditosIguais(boolean creditosIguais) {
		this.creditosIguais = creditosIguais;
	}
	public boolean isMatriculadoUniversidade() {
		return matriculadoUniversidade;
	}
	public void setMatriculadoUniversidade(boolean matriculadoUniversidade) {
		this.matriculadoUniversidade = matriculadoUniversidade;
	}
	public String toString() {
		String returnString = "";
		returnString+="Estudante "+this.getNome()+" encontrase no "+this.getAnoEscolaridade()+"º matricula";
		returnString+="\n e tem "+this.getIdade()+" anos e uma média de "+this.getMediaCurso()+" valores";
		returnString+="\n O seu Fiador é : ";
		returnString+=""+fiador;
		return returnString;
	}
}
