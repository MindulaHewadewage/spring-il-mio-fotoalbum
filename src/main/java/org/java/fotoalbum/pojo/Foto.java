package org.java.fotoalbum.pojo;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Foto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String titolo;
	private String descrizione;
	private String url;
	private Boolean visibile;
	
	
	@ManyToMany
	private List<Categoria> categorie;
	
	
	public Foto() {}

	public Foto(String titolo,String descrizione,String url,Boolean visibile,Categoria...categorie) {
		setTitolo(titolo);
		setDescrizione(descrizione);
		setUrl(url);
		setVisibile(visibile);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getVisibile() {
		return visibile;
	}

	public void setVisibile(Boolean visibile) {
		this.visibile = visibile;
	}

	public List<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(List<Categoria> categorie) {
		this.categorie = categorie;
	}
	
	@Override
	public String toString() {
		return "["+getId()+"]"+getTitolo()
		+"\nDescrizione:"+getDescrizione()
		+"\nFoto url:"+getUrl()
		+"\nVisibile:"+getVisibile();
	}
}
