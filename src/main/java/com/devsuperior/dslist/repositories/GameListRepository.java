package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.gameList;

public interface GameListRepository extends JpaRepository<gameList, Long>{
	
}
