package com.domain.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.cursomc.domain.Cidade;
import com.domain.cursomc.domain.Cliente;
import com.domain.cursomc.domain.Endereco;
import com.domain.cursomc.domain.enuns.TipoCliente;
import com.domain.cursomc.dto.ClienteDTO;
import com.domain.cursomc.dto.ClienteNewDTO;
import com.domain.cursomc.repositories.ClienteRepository;
import com.domain.cursomc.repositories.EnderecoRepository;
import com.domain.cursomc.services.exceptions.DataIntegrityException;
import com.domain.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private EnderecoRepository enredecoRepository;
	

	public Cliente find(Integer id) {
		Cliente obj = repo.findById(id).orElse(null);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName());
		}
		return obj;
	}
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		
		obj = repo.save(obj);
		enredecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}

	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Cliente porque há entidades relacionadas");
		}
	}

	public List<Cliente> findAll() {
		return repo.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		// Esse é um método do spingboot para fazer paginação
		return repo.findAll(pageRequest);
	}

	// método auxiliar que instancia Cliente apartir de um DTO
	public Cliente fromDTO(ClienteDTO objDto) {
		//throw new UnsupportedOperationException(); //Retorna que essa função não é suportada
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}
	
	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()));
		
		Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
		
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);
		
		cli.getEnderecos().add(end);
		cli.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2()!=null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3()!=null) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		
		// No caso desse service, instanciamos e adicionamos nossas classes ao Objeto de cliente assim salvando o mesmo com todas as referencias
		//Lembrando que esse método vaiu ser usado pelo nossa insert
		return cli;
	}
	
	// Método utilziado para fazer um parse e atualziar apenas os campos que desejamos
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

}
