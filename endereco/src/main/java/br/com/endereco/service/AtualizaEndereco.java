package br.com.endereco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.endereco.db.model.Endereco;
import br.com.endereco.exception.EnderecoException;
import br.com.endereco.repository.EnderecoRepository;

public class AtualizaEndereco {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public @ResponseBody String atualizaEndereco(Endereco endereco) {
		enderecoRepository.save(endereco);
		return "Atualizado";
	}

}
