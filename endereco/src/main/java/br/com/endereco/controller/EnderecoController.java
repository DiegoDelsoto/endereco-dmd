package br.com.endereco.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.endereco.db.model.Endereco;
import br.com.endereco.exception.EnderecoException;
import br.com.endereco.resource.model.EnderecoResource;
import br.com.endereco.service.AtualizaEndereco;
import br.com.endereco.service.BuscarEnderecoService;
import br.com.endereco.service.CadastroEnderecoService;

@RestController
@RequestMapping(value = "/stoom")
public class EnderecoController {	
	
	//chama os services
	@Autowired
	private CadastroEnderecoService cadastroEnderecoService;
	
	@Autowired
	private BuscarEnderecoService buscarEnderecoService;
	
	@Autowired
	private AtualizaEndereco atualizaEndereco;
	
	//METODO GET - ID ENDERECO
	//Busca o Endereco por ID, inserido o ID na URL
	@GetMapping(path = "/endereco/id/{id}")
	public Endereco buscarEnderecoById(@PathVariable(name = "id",required = true) Long id) throws EnderecoException {
		return buscarEnderecoService.buscarPorId(id);
	}
	
	//METODO POST - SALVAR ENDERECO
	@PostMapping(path = "/endereco/save")
	public void salvarEndereco(@RequestBody EnderecoResource endereco) {
		cadastroEnderecoService.cadastroEndereco(endereco);
	}
	
	//METODO DELETE - EXCLUINDO O ENDERECO
	@DeleteMapping(path = "/endereco/delete/{id}")
	public void deleteEndereco(@PathVariable(name = "id",required = true) Long id) throws EnderecoException {
		buscarEnderecoService.deletarPorId(id);
	}
	
	//METODO PUT/UPDATE  - ATUALIZAR O ENDERECO
	@PutMapping(value = "/endereco/atualiza/")
	public @ResponseBody String atualizaEndereco(@Valid @RequestBody Endereco endereco) {
		return atualizaEndereco.atualizaEndereco(endereco);
	}
	
}