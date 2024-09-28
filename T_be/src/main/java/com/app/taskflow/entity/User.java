package com.app.taskflow.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String empId;

    @NotBlank
    private String fName;

    @NotBlank
    private String lName;

    @NotBlank
    private String role;

    @Email
    @NotBlank
    private String email;

    private String suser;

    @NotBlank
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getSuser() {
        return suser;
    }

    public void setSuser(String suser) {
        this.suser = suser;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
// Getters and Setters
}




// package com.app.taskflow.controller;


// import com.app.taskflow.entity.Task;
// import com.app.taskflow.services.TaskService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// @CrossOrigin(origins="http://127.0.0.1:3000")

// @RestController
// @RequestMapping("/api/tasks")
// public class TaskController {

//     @Autowired
//     private TaskService taskService;

//     @GetMapping
//     public List<Task> getAllTasks() {
//         return taskService.getAllTasks();
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
//         Task task = taskService.getTaskById(id);
//         return task != null ? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
//     }

//     @PostMapping
//     public Task createTask(@RequestBody Task task) {
//         return taskService.createTask(task);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
//         Task updatedTask = taskService.updateTask(id, taskDetails);
//         return updatedTask != null ? ResponseEntity.ok(updatedTask) : ResponseEntity.notFound().build();
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
//         taskService.deleteTask(id);
//         return ResponseEntity.noContent().build();
//     }
// }

// task service:
// package com.app.taskflow.controller;


// import com.app.taskflow.entity.Task;
// import com.app.taskflow.services.TaskService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// @CrossOrigin(origins="http://127.0.0.1:3000")

// @RestController
// @RequestMapping("/api/tasks")
// public class TaskController {

//     @Autowired
//     private TaskService taskService;

//     @GetMapping
//     public List<Task> getAllTasks() {
//         return taskService.getAllTasks();
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
//         Task task = taskService.getTaskById(id);
//         return task != null ? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
//     }

//     @PostMapping
//     public Task createTask(@RequestBody Task task) {
//         return taskService.createTask(task);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
//         Task updatedTask = taskService.updateTask(id, taskDetails);
//         return updatedTask != null ? ResponseEntity.ok(updatedTask) : ResponseEntity.notFound().build();
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
//         taskService.deleteTask(id);
//         return ResponseEntity.noContent().build();
//     }
// }
 