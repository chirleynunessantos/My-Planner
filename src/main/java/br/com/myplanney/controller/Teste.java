package br.com.myplanney.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teste")
public class Teste {
@PostMapping
	public ResponseEntity mensagem() {
		return ResponseEntity.ok("Olá") ;
	}
}
