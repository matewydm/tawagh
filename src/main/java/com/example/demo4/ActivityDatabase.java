package com.example.demo4;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class ActivityDatabase {

    private List<Activity> activityList = new ArrayList<>();

    public void addActivity(Activity element){
        activityList.add(element);
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void deleteAll(){
        activityList.clear();
    }
}
