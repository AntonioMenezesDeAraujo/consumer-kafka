package br.com.maddytec.endereco.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.maddytec.endereco.response.EnderecoResponse;

@FeignClient(name="viacep", url="https://viacep.com.br/ws")
public interface ViaCepService {

	@GetMapping("/{cep}/json")
	EnderecoResponse obterCep(@PathVariable("cep") String cep);
}
