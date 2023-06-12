package org.java.fotoalbum.serv;

import java.util.List;
import java.util.Optional;

import org.java.fotoalbum.pojo.Foto;
import org.java.fotoalbum.repo.FotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FotoService {

	@Autowired
	private FotoRepo fotoRepo;
	
	public List<Foto>findAll(){
		return fotoRepo.findAll();
	}
	public Foto save(Foto foto) {
		return fotoRepo.save(foto);
	}
	public Optional<Foto>findById(int id){
		return fotoRepo.findById(id);
	}
	
	public List<Foto>findByTitolo(String titolo){
		return fotoRepo.findByTitolo(titolo);
	}
	
	
	public void delete(Foto foto) {
		fotoRepo.delete(foto);
	}
	
}
