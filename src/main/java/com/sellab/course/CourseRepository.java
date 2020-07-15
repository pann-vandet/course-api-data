package com.sellab.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{

	// We want to find Topic with specific id
	public List<Course> findByTopicId(String topicId);
}
