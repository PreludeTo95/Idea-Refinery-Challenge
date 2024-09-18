package com.tiger.idea_refinery_challenge;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
@CrossOrigin
public class TaskController {

    static ArrayList<Task> taskList = new ArrayList<Task>();

    {
        taskList.add(new Task(
            "1",
            "starterTask",
            "a default task",
            false,
            LocalDateTime.now(),
            null
        ));
    }

    //return all tasks
    @GetMapping("/tasks")
    public ResponseEntity<?> getTasks() {
        try {
            return new ResponseEntity<>(taskList, HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //return task based on id
    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> getTaskByID(@PathVariable String id) {
        try {
            for (Task task : taskList) {
                if (task.getId().equals(id)) {
                    return new ResponseEntity<>(task, HttpStatus.OK);
                }
            }
            ErrorResponse err = new ErrorResponse();
            err.setMessage("No task with matching ID");
            return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);

        } catch (Exception err) {
            return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //create a new task
    @PostMapping("tasks")
    public ResponseEntity<?> createTask(@RequestBody Task newTask) {
        try {
            taskList.add(newTask);
            return new ResponseEntity<>(taskList, HttpStatus.OK);
        } catch (Exception err) {
            return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //update task based on id
    @PutMapping("tasks/{id}")
    public ResponseEntity<?> updateTaskById(@RequestBody Task newTask) {
        try {
            for (int i = 0; i < taskList.size(); i++) {
                if (taskList.get(i).getId().equals(newTask.id)) {
                    taskList.set(i, newTask);
                    return new ResponseEntity<>(taskList, HttpStatus.OK);
                }
            }
            ErrorResponse err = new ErrorResponse();
            err.setMessage("No task with matching ID");
            return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
        } catch (Exception err) {
            return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
