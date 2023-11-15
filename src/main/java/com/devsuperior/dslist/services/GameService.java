package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)															//import de ve ser do spring não pode ser do jakarta, read only = true para não bloquear o campo para escrita uma vez que o DTO de retorno
	public GameDTO findById(Long id) {
		Game gameResult = gameRepository.findById(id).get();								// necessario incluir o ".get" no final por causa do tipo de retorno do metodo findById que é um optional
		return new GameDTO(gameResult);		
	}
	
	@Transactional(readOnly = true)															//import de ve ser do spring não pode ser do jakarta, read only = true para não bloquear o campo para escrita uma vez que o DTO de retorno
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();		
	}
	
	@Transactional(readOnly = true)															//import de ve ser do spring não pode ser do jakarta, read only = true para não bloquear o campo para escrita uma vez que o DTO de retorno
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();		
	}	
	
}
