package fr.uge.jee.springmvc.reststudents;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
public class StudentRestController {
    private static final Map<Long,Student> STUDENTS_MAP = Map.of(1l, new Student(1, "Tom", "Redon"), 2l, new Student(2, "Gabriel", "Eyafaa"));

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") long id) {
        var student = STUDENTS_MAP.get(id);
        if (student==null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No student with id ("+id+")");
        } else {
            return student;
        }
    }

    // Question 6 :
    @GetMapping("/students")
    public Map<Long, Student> getStudents() {
        return STUDENTS_MAP;
    }
}
