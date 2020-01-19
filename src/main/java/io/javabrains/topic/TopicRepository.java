package io.javabrains.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
    //This gives you all the standard data access methods, you can add custom ones with left-joins etc etc
}
