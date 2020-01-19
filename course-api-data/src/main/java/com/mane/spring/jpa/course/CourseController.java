package com.mane.spring.jpa.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mane.spring.jpa.topic.Topic;

@RestController
public class CourseController {
    
    @Autowired
    private CourseService courseService;
    
    @RequestMapping("topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id) {
	return courseService.getAllCourses(id);
    }
    
    @GetMapping("topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id) {
	return courseService.findCourseById(id);
    }
    
    @PostMapping("topics/{topicid}/courses")
    public void addCourse(@RequestBody Course course,@PathVariable String topicid) {
	course.setTopic(new Topic(topicid, "", ""));
	courseService.addCourse(course);
    }
    
    @PutMapping("topics/{topicid}/courses/{id}")
    public void updateTopic(@RequestBody Course course,@PathVariable String topicid,@PathVariable String id) {
	course.setTopic(new Topic(topicid, "", ""));
	courseService.updateCourse(course);
    }
    
    @DeleteMapping("topics/{topicid}/courses/{id}")
    public void deleteTopic(@PathVariable String id) {
	courseService.deleteCourseById(id);
    }
}
