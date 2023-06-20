package com.example.springbooth2.dao;

import com.example.springbooth2.modal.Alien;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlienRepo extends CrudRepository<Alien,Integer> {

    List<Alien> findByAddress(String address);
}
