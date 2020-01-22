package br.org.generation.produto.controller;


import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.produto.model.Produto;
import br.org.generation.produto.security.Autenticator;


@RestController
@CrossOrigin("*")
public class ProdutoController {
	
	@GetMapping("/produto/todos")
	public ResponseEntity<ArrayList<Produto>> getAllProdutos(@RequestParam String token){
		if (Autenticator.isValid(token)) {
			/* este trecho é simulando uma consulta ao banco de dados */
			ArrayList<Produto> lista = new ArrayList<Produto>();
			for (int i=0;i<20;i++) {
				Produto p = new Produto();
				p.setCodigo((i+1)*100);
				p.setTitulo("Produto "+(i+1));
				p.setDetalhes("Descricao "+(i+1));
				p.setPreco((i+1)*10);				
				lista.add(p);
				
			}
			return ResponseEntity.ok(lista);
		}
		else {
			return ResponseEntity.status(403).build();
		}
		
	}

}
