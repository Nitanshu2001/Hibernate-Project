package com.entity.relationship.manytomany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="courses")
@Data
public class CourseEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	Integer courseId;
	
	String courseName;
	
	@ManyToMany
	List<StudentEntity> students;
	
}
