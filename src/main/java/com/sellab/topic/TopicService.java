package com.sellab.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	//Get all lists of topics
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	//Get specific topic via its id
	public Topic getTopic(String id) {
		return topicRepository.findById(id).orElse(null);
	}

	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic);
	}

	//Update specific topic via its id
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}

	//Delete specific topic via its id
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
