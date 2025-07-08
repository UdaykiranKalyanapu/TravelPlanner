package com.uday.STPlanner.controller;

import com.uday.STPlanner.Repository.SearchRepository;
import com.uday.STPlanner.Repository.TourRepo;
import com.uday.STPlanner.model.Tours;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class TourController {
    @Autowired
    TourRepo repo;
    @Autowired
    SearchRepository srepo;




    @Hidden
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html");  // Correct Springdoc Swagger UI path
    }


    @GetMapping("/tours")
    @Operation(summary = "Get all available tours", description = "Fetches the list of all available travel tours from the database.")
    public List<Tours> getAllTours() {
        return repo.findAll();
    }
    @PostMapping("tours")
    @Operation(summary = "save a tour details", description = "saves the tour details ")
    public Tours saveTour(@RequestBody Tours tourdetails){
        return repo.save(tourdetails);
    }

    @GetMapping("/tours/{text}")
    @Operation(summary = "Search with Destination Country name")
    public List<Tours> searchTours(@PathVariable String text){
        return srepo.findTours(text);
    }

}