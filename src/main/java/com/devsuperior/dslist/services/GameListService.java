package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.gameList;
import com.devsuperior.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
		
	@Transactional(readOnly = true)															//import de ve ser do spring não pode ser do jakarta, read only = true para não bloquear o campo para escrita uma vez que o DTO de retorno
	public List<GameListDTO> findAll(){
		List<gameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();	
	}	
	
}
