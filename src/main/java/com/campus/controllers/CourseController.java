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

import com.campus.entities.Course;
import com.campus.repositories.CourseRepository;

@RestController
@RequestMapping("/courses")
public class CourseController
{

	@Autowired
	private CourseRepository courseRepository;

	@PostMapping
	public Course addCourse(@RequestBody Course course)
	{
		return courseRepository.save(course);
	}

	@GetMapping
	public List<Course> getAllCourses()
	{
		return courseRepository.findAll();
	}
	
	 @GetMapping("/{id}")
	    public Course getCourseById(@PathVariable Long id) {
	        return courseRepository.findById(id).orElse(null);
	    }

	  
	    @PutMapping("/{id}")
	    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {

	        Optional<Course> existing = courseRepository.findById(id);

	        if(existing.isPresent()) {
	            Course c = existing.get();
	            c.setCourseName(course.getCourseName());
	            c.setDuration(course.getDuration());
	            return courseRepository.save(c);
	        }

	        return null;
	    }

	  
	    @DeleteMapping("/{id}")
	    public String deleteCourse(@PathVariable Long id) {
	        courseRepository.deleteById(id);
	        return "Course Deleted Successfully";
	    }
}