package org.isetn.RestControllers;

import java.util.List;
import java.util.Optional;

import org.isetn.entities.Etudiant;
import org.isetn.entities.Formation;
import org.isetn.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("etudiant")

public class EtudiantController {
	@Autowired
	private EtudiantRepository etudiantRepository;

	@PostMapping("/add")
	public Etudiant add(@RequestBody Etudiant etudiant ) {
		System.out.println("etud");
		System.out.println(etudiant.getClasse());
		return etudiantRepository.save(etudiant);
	}

	@GetMapping("/all")
	public List<Etudiant> getAll() {
		return etudiantRepository.findAll();
	}
	
	@GetMapping("/findByClasseId/{id}")
	public List<Etudiant> getByClasseId(@PathVariable Long id) {
		return etudiantRepository.findByClasseCodClass(id);
	}
	
	@GetMapping("/get/{id}")
	public Optional<Etudiant> getById(@PathVariable Long id) {
		return etudiantRepository.findById(id);
	}
	
	
	
	@DeleteMapping("/delete")
	public void delete(@Param("id") Long id)
	{
		Etudiant c =  etudiantRepository.findById(id).get();
		etudiantRepository.delete(c);
	}
	
	@PutMapping("/update")
	public Etudiant update(@RequestBody Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}
}
