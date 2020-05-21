package com.example.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public Map<String, List<Topic>> getAllTopics() {
        Map<String,List<Topic>> response = new HashMap<String,List<Topic>>();
        response.put("topics", topicService.getAllTopics());
        return response;
    }

    @RequestMapping("/topics/{id}")
    public Optional<Topic> getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @RequestMapping(method= RequestMethod.POST,value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @RequestMapping(method=RequestMethod.PUT,value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic,@PathVariable String id) {
        topicService.updateTopic(topic,id);
    }

    @RequestMapping(method=RequestMethod.DELETE,value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }



}
