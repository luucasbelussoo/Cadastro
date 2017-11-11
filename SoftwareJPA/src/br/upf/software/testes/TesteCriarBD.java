package br.upf.software.testes;

import javax.persistence.Persistence;

public class TesteCriarBD {
	public static void main(String[] args){
		Persistence.createEntityManagerFactory("SoftwareJPA");
	}
}
