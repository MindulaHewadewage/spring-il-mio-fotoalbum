package org.java.fotoalbum.controller;

import java.util.List;
import java.util.Optional;

import org.java.fotoalbum.pojo.Categoria;
import org.java.fotoalbum.pojo.Foto;
import org.java.fotoalbum.serv.CategoriaService;
import org.java.fotoalbum.serv.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FotoController {
	@Autowired
	private FotoService fotoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/")
	public String getFotoIndex(Model model) {
		List<Foto>fotos=fotoService.findAll();
		model.addAttribute("fotos", fotos);
		return "foto-index";
	}
	
	@GetMapping("/fotos/{id}")
	public String getFotoShow(
			Model model,
			@PathVariable int id
		) {
		
		Optional<Foto> optFoto = fotoService.findById(id);
		Foto foto = optFoto.get();
		
		model.addAttribute("foto", foto);
		
		return "foto-show";
	}
	
	
	
	@GetMapping("/fotos/create")
	public String createNewFoto(Model model) {
		List<Categoria>categorie=categoriaService.findAll();
		model.addAttribute("foto",new Foto());
		model.addAttribute("categorie",categorie);
		return "foto-create";
	}
	
	@PostMapping("/fotos/create")
	public String storeNewFoto(Model model ,@ModelAttribute Foto foto,BindingResult bindingResult) {
		
		model.addAttribute("foto", foto);
		fotoService.save(foto);
		return "redirect:/";
	}
	
	
	@PostMapping("/fotos/search")
	public String getFotosByTitolo(
			Model model,
			@RequestParam("search") String titolo
			) {
		
		List<Foto> fotos = fotoService.findByTitolo(titolo);
		model.addAttribute("fotos", fotos);
		model.addAttribute("search", titolo);
		
		return "foto-index";
	}
	
	@GetMapping("/fotos/update/{id}")
	public String getFotoUpdate(Model model, @PathVariable int id) {
		Optional<Foto> optFoto=fotoService.findById(id);
		Foto foto = optFoto.get();
		model.addAttribute("foto", foto);
		return "foto-update";
	}
	
	@PostMapping("/fotos/update/{id}")
	public String storeFotoUpdated(@PathVariable int id,@ModelAttribute Foto foto) {
		fotoService.save(foto);
		return "redirect:/";
	}
	
	@GetMapping("/fotos/delete/{id}")
	public String deleteFoto(@PathVariable int id) {
		Optional<Foto> optFoto=fotoService.findById(id);
		Foto foto = optFoto.get();
		fotoService.delete(foto);
		return "redirect:/";
	}
}
