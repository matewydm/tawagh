package com.example.demo4;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class ActivityDatabase {

    private List<Activity> activityList = new ArrayList<>();
    private int activityIndex = 1;

    public void addActivity(Activity element){
        element.setId(activityIndex);
        activityList.add(element);
        activityIndex = activityIndex + 1;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public List<Activity> getActivityList(Integer priority, String name) {
        if (priority == null && name == null) {
            return activityList;
        }
        List<Activity> filteredActivities = new ArrayList<>();
        for (Activity activity : activityList) {
            if (name == null && activity.getPriority().equals(priority)) {
                filteredActivities.add(activity);
            } else if (priority == null && activity.getName().equals(name)) {
                filteredActivities.add(activity);
            } else if (activity.getName().equals(name) && activity.getPriority().equals(priority)) {
                filteredActivities.add(activity);
            }
        }
        return filteredActivities;
    }


    public void deleteAll(){
        activityList.clear();
    }

    public Activity getActivityById(Integer id) {
        for (Activity element : activityList) {
            if (element.getId().equals(id)) {
                return element;
            }
        }
        return null;
    }

    public boolean deleteById(Integer id) {
        Activity activityToDelete = null;
        for (Activity element : activityList) {
            if (element.getId().equals(id)) {
                activityToDelete = element;
            }
        }
        if (activityToDelete == null) {
            return false;
        }
        activityList.remove(activityToDelete);
        return true;
    }
}
