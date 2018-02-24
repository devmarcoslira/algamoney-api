package com.example.algamoneyapi.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoneyapi.event.RecursoCriadoEvent;
import com.example.algamoneyapi.model.Pessoa;
import com.example.algamoneyapi.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaRepository pessoaRepository; 
	
	@GetMapping
	public List<Pessoa> listar(){
		
		return pessoaRepository.findAll(); //".findAll()" está realizando o select na tabela pessoa -- select * from pessoa
	}
	
	@Autowired
	private ApplicationEventPublisher publisher; 
	
	@PostMapping
	//método criado para inserir pessoas na tabela pessoa
	public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
		
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
		
		
	}
	//método criado para conseguirmos buscar a pessoa pelo número do código
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Pessoa> buscarPeloCodigo(@PathVariable Long codigo) {
		 Pessoa pessoa = pessoaRepository.findOne(codigo);
		 return pessoa != null ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build(); // desafio: validando a inserção de um ID inexistente na URI
	}

}
