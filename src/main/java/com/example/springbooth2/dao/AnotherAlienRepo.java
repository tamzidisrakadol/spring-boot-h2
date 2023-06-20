package com.example.springbooth2.dao;

import com.example.springbooth2.modal.Alien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnotherAlienRepo extends JpaRepository<Alien,Integer> {

}
