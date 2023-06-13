package org.java.fotoalbum.controller;

import java.util.List;

import org.java.fotoalbum.pojo.Categoria;
import org.java.fotoalbum.pojo.Foto;
import org.java.fotoalbum.serv.CategoriaService;
import org.java.fotoalbum.serv.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorie")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private FotoService fotoService;
	
	
	@GetMapping
	public String getCategoriaIndex(Model model) {
		
		List<Categoria>categorie=categoriaService.findAll();
		model.addAttribute("categorie",categorie);
		
		return"categoria-index";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCategoria(@PathVariable int id) {
		
		Categoria categoria=categoriaService.findById(id).get();
		for(Foto f :categoria.getFotos()) {
			f.removeCategoria(categoria);
			fotoService.save(f);
		}
		categoriaService.delete(categoria);
		
		return"redirect:/categorie";
	}
	
	@GetMapping("/create")
	public String createNewCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "categoria-create";
	}
	
	@PostMapping("/create")
	public String storeNewCategoria(Model model,@ModelAttribute Categoria catogoria) {
		categoriaService.save(catogoria);
		return "redirect:/categorie";
	}
}
