package br.com.myplanney.core.habitos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.myplanney.core.habitos.service.HabitosService;
import br.com.myplanney.dto.request.HabitoRequestDTO;
import br.com.myplanney.dto.response.HabitoResponsetDTO;
import br.com.myplanney.mapper.HabitoMapper;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("habitos")
@RequiredArgsConstructor
public class HabitosController {

	private final HabitoMapper mapper;
	private final HabitosService service;
	
	public ResponseEntity<HabitoResponsetDTO> salvar(HabitoRequestDTO habitoDTO){
		
		return ResponseEntity.ok(mapper.paraHabitoResponsetDTO(
				service.salvar(
						mapper.paraHabitos(habitoDTO)
				)));
		
	}
}
