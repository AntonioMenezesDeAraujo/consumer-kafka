package br.com.maddytec.endereco.http;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoJson {

	private String cep;
	private Long numero;
	private String complemento;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public EnderecoJson(String cep, Long numero, String complemento) {
		super();
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
	}

	public EnderecoJson() {
		super();
	}

}
