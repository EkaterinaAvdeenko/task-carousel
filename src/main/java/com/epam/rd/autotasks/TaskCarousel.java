package com.epam.rd.autotasks;
import java.util.ArrayList;
import java.util.List;
public class TaskCarousel {
    private final List<Task> tasks;
    private final int capacity;
    private int counter = -1;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        this.tasks = new ArrayList<>();
    }

    public boolean addTask(Task task) {
        int value = 1;
        if(task instanceof CountDownTask) value = ((CountDownTask) task).getValue();
        if(!task.isFinished() && !isFull() && value != 0) {
            return tasks.add(task);
        }
        return false;
    }

    public boolean execute() {
        if (!isEmpty()) {counter++;
            if(counter == tasks.size()) counter = 0;
            Task task = tasks.get(counter);

            // вызывается метод CountDownLatch
            task.execute();

            if(task.isFinished()) {
                tasks.remove(task);
                counter--;
            }
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return tasks.size() == capacity;
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

}