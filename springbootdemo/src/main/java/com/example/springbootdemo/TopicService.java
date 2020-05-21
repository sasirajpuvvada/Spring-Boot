package com.example.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    private List<Topic> topics = new ArrayList<>(Arrays.asList (
            new Topic("Spring","Spring FrameWork data","Spring Frame work descreption"),
            new Topic("java","java FrameWork data","Java Frame work descreption"),
            new Topic("javascript","javascript FrameWork data","java script Frame work descreption")
    ));

    public List<Topic> getAllTopics() {
//		return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(String id) {
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
//		topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }


}
