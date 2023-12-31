package org.java.fotoalbum.pojo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public String nome;
	
	@ManyToMany(mappedBy = "categorie")
	public List<Foto> fotos;
	
	
	public Categoria() {}
	
	public Categoria(String nome) {
		setNome(nome);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	@Override
	public String toString() {
		return "["+getId()+"]" + getNome();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Categoria)) return false;
		Categoria objCat=(Categoria)obj;
		return getId()==objCat.getId();
	}
}
