package com.mane.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService{
    
    private List<Topic> TOPICS = new ArrayList<Topic>( Arrays.asList(new Topic("1", "Spring", "Spring practice"),
	    new Topic("2", "Java", "Java learning"), new Topic("3", "Python", "Python learning")));

    public List<Topic> getAllTopics() {
	return TOPICS;
    }

    public Topic findTopicById(String id) {
	return TOPICS.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
	TOPICS.add(topic);
    }

    public void updateTopic(Topic topic, String id) {
	for(int i=0 ; i<TOPICS.size();i++) {
	    if(TOPICS.get(i).getId().equals(id)) {
		TOPICS.set(i, topic);
		return;
	    }
	}
    }

    public void deleteTopicById(String id) {
	TOPICS.removeIf(t -> t.getId().equals(id));
    }
}
