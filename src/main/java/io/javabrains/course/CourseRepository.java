package io.javabrains.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {
    //defining a custom  lookup for a list of courses associated with a topic
    //public List<Course> getCousesByTopic(String topicId);
    //public List<Course> findByName(String name);
    //public List<Course> findByDescription(String description);
    public List<Course> findByTopicId(String id);

}
