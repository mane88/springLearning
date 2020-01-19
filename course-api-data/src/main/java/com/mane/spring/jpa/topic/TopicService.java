package com.mane.spring.jpa.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService{
    
    @Autowired
    private TopicRepository topicRepo;

    public List<Topic> getAllTopics() {
	//return TOPICS;
	List<Topic> topics = new ArrayList<Topic>();
	 topicRepo.findAll().forEach(topics::add);
	 return topics;
    }

    public Topic findTopicById(String id) {
	Optional<Topic> topic = topicRepo.findById(id);
	return topic.get();
    }

    public void addTopic(Topic topic) {
//	TOPICS.add(topic);
	topicRepo.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
	topicRepo.save(topic);
    }

    public void deleteTopicById(String id) {
	topicRepo.deleteById(id);
    }
}
