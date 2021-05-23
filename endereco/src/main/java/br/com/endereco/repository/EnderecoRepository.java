package br.com.endereco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.endereco.db.model.Endereco;

//JPARepository vai direto com a entidade Endereco, sem precisar do INSERT INTO, UPDATE ETC..
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
