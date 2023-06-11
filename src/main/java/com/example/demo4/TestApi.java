package com.example.demo4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TestApi {

    @Autowired
    private ActivityDatabase activityDatabase;

    @GetMapping("test")
    public String testApi() {
        return "test";
    }

    @PostMapping(value = "activities",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void addNewActivity(@RequestBody Activity element){
        activityDatabase.addActivity(element);
    }

    @GetMapping(value = "activities",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Activity> getActivities() {
        return activityDatabase.getActivityList();
    }

    @DeleteMapping(value = "activities")
    public void deleteAll(){
        activityDatabase.deleteAll();
    }


}
