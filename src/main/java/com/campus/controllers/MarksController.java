package com.campus.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.entities.Marks;
import com.campus.repositories.MarksRepository;

@RestController
@RequestMapping("/marks")

public class MarksController
{
	@Autowired
	private MarksRepository marksRepository;

	@PostMapping
	public ResponseEntity<String> save(@RequestBody Marks marks){
		marksRepository.save(marks);
	    return ResponseEntity.ok("Marks Saved Successfully");
	}


	@GetMapping
	public List<Marks> get()
	{
		return marksRepository.findAll();
	}

	@GetMapping("/{id}")
	public Marks get(@PathVariable Long id)
	{
		return marksRepository.findById(id).orElse(null);
	}

	@PutMapping("/{id}")
	public Marks update(@PathVariable Long id, @RequestBody Marks marks)
	{

		Optional<Marks> existing = marksRepository.findById(id);

		if (existing.isPresent())
		{
			Marks m = existing.get();
			m.setScore(marks.getScore());
			m.setStudent(marks.getStudent());
			m.setCourse(marks.getCourse());
			return marksRepository.save(m);
		}

		return null;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id)
	{
		marksRepository.deleteById(id);
		return "Marks Deleted Successfully";
	}
}