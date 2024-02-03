package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.Work;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    UserRepository repo;

    @GetMapping("/user/{userName}/{password}")
    public User getUserByUserNameAndPassword(@PathVariable String userName, @PathVariable String password)
    {
        return repo.findUserByUserNameAndUserPassword(userName,password);
    }

    @PostMapping("/user/add/")
    public void createUser(@RequestBody User user)
    {
        repo.save(user);
    }

    /**
    @GetMapping("/user/worksBetween/{idUser}/{year1}/{month1}/{day1}/{h1}/{m1}/{s1}/{year2}/{month2}/{day2}/{h2}/{m2}/{s2}")
    public List<Work> getWorksBetweenDates(@PathVariable Integer idUser,@PathVariable Integer year1,@PathVariable Integer month1,@PathVariable Integer day1 ,@PathVariable Integer h1,@PathVariable Integer m1,@PathVariable Integer s1,@PathVariable Integer year2, @PathVariable Integer month2,@PathVariable Integer day2, @PathVariable Integer h2,@PathVariable Integer m2,@PathVariable Integer s2)
    {
        List<Work> userWorks = repo.findById(idUser).get().getWorks();
        List<Work> answer = new ArrayList<>();


        LocalDateTime dateStart = LocalDateTime.of(year1,month1,day1,h1,m1,s1);
        LocalDateTime dateEnd = LocalDateTime.of(year2,month2,day2,h2,m2,s2);
        for(Work e: userWorks)
        {
            if(e.getStart().isAfter(dateStart) && e.getStop().isBefore(dateEnd))
            {
                answer.add(e);
            }
        }
        return answer;

    }
    */

    @GetMapping("/user/worksBetween/{idUser}")
    public List<Work> getWorksBetweenDates(@PathVariable Integer idUser)   {
        List<Work> userWorks = repo.findById(idUser).get().getWorks();
        List<Work> answer = new ArrayList<>();


        LocalDateTime dateEnd = LocalDateTime.now();
        LocalDateTime dateStart = dateEnd.minusDays(7);
        for(Work e: userWorks)
        {
            if(e.getStart().isAfter(dateStart) && e.getStop().isBefore(dateEnd))
            {
                answer.add(e);
            }
        }
        return answer;

    }

}
