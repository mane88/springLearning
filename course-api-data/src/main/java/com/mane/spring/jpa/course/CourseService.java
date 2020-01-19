package com.mane.spring.jpa.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService{
    
    @Autowired
    private CourseRepository courseRepo;

    public List<Course> getAllCourses(String id) {
	//return TOPICS;
	List<Course> course = new ArrayList<Course>();
	 courseRepo.findByTopicId(id)
	 .forEach(course::add);
	 return course;
    }

    public Course findCourseById(String id) {
	Optional<Course> topic = courseRepo.findById(id);
	return topic.get();
    }

    public void addCourse(Course course) {
//	TOPICS.add(topic);
	courseRepo.save(course);
    }

    public void updateCourse(Course course) {
	courseRepo.save(course);
    }

    public void deleteCourseById(String id) {
	courseRepo.deleteById(id);
    }
}
