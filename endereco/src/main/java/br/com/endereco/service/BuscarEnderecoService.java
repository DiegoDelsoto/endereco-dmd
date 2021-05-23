package br.com.endereco.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.endereco.db.model.Endereco;
import br.com.endereco.exception.EnderecoException;
import br.com.endereco.repository.EnderecoRepository;

@Service
public class BuscarEnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	//BUSCA POR ENDERECO ID
	public Endereco buscarPorId(Long id) throws EnderecoException {		
		Optional<Endereco> optionalEndereco = enderecoRepository.findById(id);
		Endereco endereco = null;		
		if (!optionalEndereco.isPresent()) {
			throw new EnderecoException("Endereço não encontrado pelo ID: "+id);
		}else {
			endereco = optionalEndereco.get();
		}
		return endereco;
	}
	
	//DELETA POR ENDERECO ID
	public void deletarPorId(Long id) throws EnderecoException {
		Optional<Endereco> optionalEndereco = enderecoRepository.findById(id);		
		if (!optionalEndereco.isPresent()) {
			throw new EnderecoException("Endereço não encontrado pelo ID: "+id);
		}else {
			enderecoRepository.deleteById(id);
		}
	}
}
