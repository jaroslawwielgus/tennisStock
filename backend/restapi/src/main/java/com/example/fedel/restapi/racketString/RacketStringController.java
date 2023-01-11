package com.example.fedel.restapi.racketString;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/racket-strings")
public class RacketStringController {

    @Autowired
    private RacketStringRepository repository;

    @GetMapping("")
    List<RacketString> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    RacketString findOne(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("")
    RacketString create(@RequestBody RacketString racketString) {
        return repository.save(racketString);
    }

    @PutMapping("/{id}")
    RacketString update(@PathVariable int id, @RequestBody RacketString racketString) {
        RacketString oldRacketString = repository.findById(id).orElse(null);
        // System.out.println(racketString.getName());
        oldRacketString.setName(racketString.getName());
        oldRacketString.setDescription(racketString.getDescription());
        oldRacketString.setImage(racketString.getImage());
        oldRacketString.setType(racketString.getType());
        oldRacketString.setDiameter(racketString.getDiameter());
        oldRacketString.setLength(racketString.getLength());
        oldRacketString.setColor(racketString.getColor());
        oldRacketString.setPrice(racketString.getPrice());
        return repository.save(oldRacketString);
    }

    @PatchMapping("/{id}")
    RacketString partiallyUpdate(@PathVariable int id, @RequestBody RacketString racketString) {
        RacketString oldRacketString = repository.findById(id).orElse(null);
        // System.out.println(racket.getName());
        if (racketString.getName() != null) {
            oldRacketString.setName(racketString.getName());
        }
        if (racketString.getDescription() != null) {
            oldRacketString.setDescription(racketString.getDescription());
        }
        if (racketString.getImage() != null) {
            oldRacketString.setImage(racketString.getImage());
        }
        if (racketString.getType() != null) {
            oldRacketString.setType(racketString.getType());
        }
        if (racketString.getDiameter() > 0) {
            oldRacketString.setDiameter(racketString.getDiameter());
        }
        if (racketString.getLength() > 0) {
            oldRacketString.setLength(racketString.getLength());
        }
        if (racketString.getColor() != null) {
            oldRacketString.setColor(racketString.getColor());
        }
        if (racketString.getPrice() > 0) {
            oldRacketString.setPrice(racketString.getPrice());
        }
        return repository.save(oldRacketString);
    }

    @DeleteMapping("")
    Integer destroyAll() {
        repository.deleteAll();
        return 1;
    }

    @DeleteMapping("/{id}")
    Integer destroy(@PathVariable int id) {
        repository.deleteById(id);
        return id;
    }
}
