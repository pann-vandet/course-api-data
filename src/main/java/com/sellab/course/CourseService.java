package com.sellab.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	//Get all lists of topics
	public List<Course> getAllCourses(String topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
	}
	
	//Get specific course via its id
	public Course getCourse(String id) {
		return courseRepository.findById(id).orElse(null);
	}

	//Add new course
	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	//Update specific course via its id
	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	//Delete specific course via its id
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
}
