package com.sellab.lesson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;
	
	//Get all lists of topics
	public List<Lesson> getAllLessons(String topicId, String courseId) {
		List<Lesson> lessons = new ArrayList<>();
		lessonRepository.findByCourseId(courseId)
		.forEach(lessons::add);
		return lessons;
	}
	
	//Get specific course via its id
	public Lesson getLesson(String id) {
		return lessonRepository.findById(id).orElse(null);
	}

	//Add new course
	public void addLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}


	//Update specific course via its id
	public void updateLesson(Lesson lesson) {
		lessonRepository.save(lesson);
	}

	//Delete specific course via its id
	public void deleteLesson(String id) {
		lessonRepository.deleteById(id);
	}
}
