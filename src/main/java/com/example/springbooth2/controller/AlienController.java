package com.example.springbooth2.controller;


import com.example.springbooth2.dao.AlienRepo;
import com.example.springbooth2.dao.AnotherAlienRepo;
import com.example.springbooth2.modal.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class AlienController {

    @Autowired
    AlienRepo alienRepo;  // for crud-operation with database

    @Autowired
    AnotherAlienRepo anotherAlienRepo;  // for crud-operation with json format


    //main html page as jsp
    @RequestMapping("/home")
    public String home(){
        return "home.jsp";
    }

    //adding alien form main page to h2
    //must be same action name with RequestMapping
    @RequestMapping("/addAlien")
    public String addAlien(Alien alien){
        alienRepo.save(alien);
        return "home.jsp";
    }


    //showing alien object in another html file
    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("showAlien.jsp");
        Alien alien = alienRepo.findById(id).orElse(new Alien());
        modelAndView.addObject(alien);
        return modelAndView;
    }

    //fetching list of alien object by their address
    @RequestMapping("/getAlienByAddress")
    public ModelAndView getAlienbyAddress(@RequestParam String address){
        ModelAndView modelAndView = new ModelAndView("showAlien.jsp");
        List<Alien>alienList = alienRepo.findByAddress(address);
        System.out.println(alienList);
        modelAndView.addObject(alienList);
        return modelAndView;
    }


    //convert all saved data in h2 to json format
    @RequestMapping("/getRestAliens")
    @ResponseBody
    public List<Alien> getRestAlien(){
        return anotherAlienRepo.findAll();
    }

    //fetching alien object by their id in json format
    @RequestMapping("/restAlienID/{id}")
    @ResponseBody
    public Optional<Alien> getRestAlienByID(@PathVariable("id") int id){
        return anotherAlienRepo.findById(id);
    }




}
