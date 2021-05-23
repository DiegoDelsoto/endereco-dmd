package br.com.endereco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.endereco.db.model.Endereco;
import br.com.endereco.exception.EnderecoException;
import br.com.endereco.repository.EnderecoRepository;
import br.com.endereco.resource.model.EnderecoResource;

@Service
public class CadastroEnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EnderecoConversor enderecoConversor;
	
	public void cadastroEndereco(EnderecoResource enderecoResource) {		
		try {
			Endereco end = enderecoConversor.conversor(enderecoResource);
			enderecoRepository.saveAndFlush(end);
		} catch (EnderecoException e) {
			e.printStackTrace();
		}		
	}

}
