package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.Work;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class WorkController {
    @Autowired
    WorkRepository repo;

    @Autowired
    UserRepository userRepo;

    @PostMapping("/work/add/{userId}")
    public void addWork(@PathVariable Integer userId,@RequestBody Work work)
    {
        try {
            User user = userRepo.findById(userId).get();
            work.setUser(user);
            repo.save(work);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }




}
