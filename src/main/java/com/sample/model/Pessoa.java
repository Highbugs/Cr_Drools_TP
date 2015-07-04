package com.sample.model;

public class Pessoa {
	private String nome;
	private int idade;
	private boolean historicoIncumprimento;
	private boolean contaBancaria;
	public String getNome() {
		return nome;
	}
	public boolean isContaBancaria() {
		return contaBancaria;
	}
	public void setContaBancaria(boolean contaBancaria) {
		this.contaBancaria = contaBancaria;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Pessoa(String nome, int idade, boolean historicoIncumprimento) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.historicoIncumprimento = historicoIncumprimento;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public boolean isHistoricoIncumprimento() {
		return historicoIncumprimento;
	}
	public void setHistoricoIncumprimento(boolean historicoIncumprimento) {
		this.historicoIncumprimento = historicoIncumprimento;
	}
}
