package com.campus.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Course
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String courseName;
	private String duration;
}