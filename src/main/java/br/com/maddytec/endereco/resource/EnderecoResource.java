package br.com.maddytec.endereco.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.maddytec.endereco.http.EnderecoJson;
import br.com.maddytec.endereco.response.EnderecoResponse;
import br.com.maddytec.endereco.service.EnderecoService;
import br.com.maddytec.endereco.service.ViaCepService;

@RestController
@RequestMapping("endereco")
public class EnderecoResource {

	@Autowired
	private ViaCepService viaCepService; 
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping("/{cep}")
	public ResponseEntity<EnderecoResponse> obterCep(@PathVariable("cep")String cep) {
		EnderecoResponse enderecoResponse = viaCepService.obterCep(cep);
		return ResponseEntity.ok(enderecoResponse);
	}
	
	@PostMapping
	public ResponseEntity<EnderecoResponse> enviarEndereco(@RequestBody EnderecoJson enderecoJson ) throws JsonProcessingException {
		System.out.println("##### Dados enviados pelo cliente: " + enderecoJson);
		
		EnderecoResponse enderecoResponse = viaCepService.obterCep(enderecoJson.getCep());
		
		enderecoResponse.setComplemento(enderecoJson.getComplemento());
		enderecoResponse.setNumero(enderecoJson.getNumero());
		
		ObjectMapper objectMapper = new ObjectMapper();
		String messagem = objectMapper.writeValueAsString(enderecoResponse);
		
		enderecoService.sendMessage(messagem);
		System.out.println("### Endereco retornado pela API de CEP : " + enderecoResponse);
		
		return ResponseEntity.ok(enderecoResponse);
	}
}
