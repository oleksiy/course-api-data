package io.javabrains.course;

import io.javabrains.topic.Topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Course {

    @Id
    private String id; // this is now the primary key
    private String name;
    private String description;
    @ManyToOne
    private Topic topic;

    /**
     * Default constructor.
     * This constructor is necessary due to error encountered when posting a new topic
     * {
     *     "timestamp": 1579324808061,
     *     "status": 400,
     *     "error": "Bad Request",
     *     "exception": "org.springframework.http.converter.HttpMessageNotReadableException",
     *     "message": "JSON parse error: Can not construct instance of io.javabrains.springbootstarter.topic.Topic:
     *     no suitable constructor found, can not deserialize from Object value (missing default constructor or creator,
     *     or perhaps need to add/enable type information?);
     *     nested exception is com.fasterxml.jackson.databind.JsonMappingException:
     *     Can not construct instance of io.javabrains.springbootstarter.topic.Topic: no suitable constructor found,
     *     can not deserialize from Object value (missing default constructor or creator, or perhaps need to add/enable
     *     type information?)\n at [Source: java.io.PushbackInputStream@1444d389; line: 2, column: 5]",
     *     "path": "/topics"
     * }
     */
    public Course() {
        super();
        this.id = "nothing";
        this.name = "nothing";
        this.description = "nothing";

    }

    public Course(String id, String name, String description, String topicId) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic = new Topic(topicId, "", "");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic getTopic() {
        return this.topic;
    }

    public void setTopic(Topic t) {
        this.topic = t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return getId().equals(course.getId()) &&
                Objects.equals(getName(), course.getName()) &&
                Objects.equals(getDescription(), course.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription());
    }
}
