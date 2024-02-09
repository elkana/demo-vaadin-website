package com.example.demovaadinwebsite.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demovaadinwebsite.model.McUser;

public interface UserRepo extends JpaRepository<McUser, String>{
    
}
