package com.sellab.lesson;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sellab.course.Course;

@RestController
public class LessonController {

	@Autowired
	private LessonService lessonService; 
	
	//We get all courses which belong to specific topic, so we need @PathVariable of topic id
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public List<Lesson> getAllLessons(@PathVariable String topicId, @PathVariable String courseId) {
		return lessonService.getAllLessons(topicId, courseId);
	}
	
	//Get specific lesson belong to course id
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public Lesson getLesson(@PathVariable String id) {
		return lessonService.getLesson(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/topics/{topicId}/courses/{courseId}/lessons")
	public void addCourse(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId) {
		lesson.setCourse(new Course(courseId, "", "", topicId ));
		lessonService.addLesson(lesson);
	}
	

	@RequestMapping(method = RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void updateCourse(@RequestBody Lesson lesson, @PathVariable String topicId,@PathVariable String courseId, @PathVariable String id) {
		lesson.setCourse(new Course(courseId, "", "", topicId ));
		lessonService.updateLesson(lesson);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void deleteCourse(@PathVariable String id) {
		lessonService.deleteLesson(id);
	}
	
}
