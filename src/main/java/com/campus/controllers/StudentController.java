package com.campus.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.entities.Student;
import com.campus.repositories.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController
{

	@Autowired
	private StudentRepository studentRepository;

	@PostMapping
	public Student addStudent(@RequestBody Student student)
	{
		return studentRepository.save(student);
	}

	@GetMapping
	public List<Student> get()
	{
		return studentRepository.findAll();
	}

	@GetMapping("/{id}")
	public Student get(@PathVariable Long id)
	{
		return studentRepository.findById(id).orElse(null);
	}

	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student)
	{

		Optional<Student> existing = studentRepository.findById(id);

		if (existing.isPresent())
		{
			Student s = existing.get();
			s.setName(student.getName());
			s.setEmail(student.getEmail());
			return studentRepository.save(s);
		}

		return null;
	}

	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		studentRepository.deleteById(id);
		return "Student Deleted Successfully";
	}
}