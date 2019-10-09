package com.codefellows.taskmaster;

import com.codefellows.taskmaster.models.Task;
import com.codefellows.taskmaster.models.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/")
    public String getRoot() {
        return "this is an api now!";
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Task getOneTask(@PathVariable long id) {
        return taskRepository.getOne(id);
    }

    @PostMapping("/tasks")
    public String createTask(String title, String body) {
        Task newTask = new Task(title, body, null, "new");
        taskRepository.save(newTask);
        return "task created!";
    }

    @PutMapping("/tasks/{id}")
    public String updateTask(@PathVariable long id) {
        return "updated!";
    }
}
