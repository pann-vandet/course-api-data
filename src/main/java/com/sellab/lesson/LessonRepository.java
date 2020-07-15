package com.sellab.lesson;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson, String>{

	// We want to find Course with specific id
	public List<Lesson> findByCourseId(String courseId);
}
