package com.devsuperior.dslist.projections;

/* Consulta SQL Customizada no spring DATA JPA
 * classe Projection de consultas gets para SQL da classe GameRepostory 
 * Todos os metodos gets criados referem-se aos campos de projeção da consulta SQL da classe "GameRepostory"
 * Atenção os nomes antes do prefixo get precisam ser exatamente iguais aos campos da projeção na consulta SQL
 * */

public interface GameMinProjection {
	
	Long getId();
	String getTitle();
	Integer getGameYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
}
