package br.com.endereco.service;

import org.springframework.stereotype.Component;

import br.com.endereco.db.model.Endereco;
import br.com.endereco.exception.EnderecoException;
import br.com.endereco.resource.model.EnderecoResource;

@Component
public class EnderecoConversor {
	
	public Endereco conversor(EnderecoResource enderecoResource) throws EnderecoException {
		
		try {
			Endereco endereco = new Endereco();
			
			Integer number = checkNumber(enderecoResource.getNumber());
			
			endereco.setStreetName(enderecoResource.getStreetName());
			endereco.setNumber(number);
			endereco.setComplement(enderecoResource.getComplement());
			endereco.setNeighbourhood(enderecoResource.getNeighbourhood());
			endereco.setCity(enderecoResource.getCity());
			endereco.setState(enderecoResource.getState());
			endereco.setCountry(enderecoResource.getCountry());
			endereco.setZipcode(enderecoResource.getZipcode());
			endereco.setLatitude(enderecoResource.getLatitude());
			endereco.setLongitude(enderecoResource.getLongitude());			
		} catch (Exception e) {
			throw new EnderecoException("Falha:"+ enderecoResource);
		}
		return null;
		
	}
	
	private Integer checkNumber(String number) {
		return Integer.parseInt(number);
	}
}
