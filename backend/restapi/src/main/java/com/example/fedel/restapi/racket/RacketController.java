package com.example.fedel.restapi.racket;

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
@RequestMapping("/rackets")
public class RacketController {

    @Autowired
    private RacketRepository repository;

    @GetMapping("")
    List<Racket> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Racket findOne(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("")
    int create(@RequestBody List<Racket> rackets) {
        int recordsNumber = 0;
        for (Racket racket : rackets) {
            if (racket.getStrungWeight() > 0 && racket.getBalance() > 0
                    && racket.getLength() > 0 && racket.getHeadSize() > 0
                    && racket.getStiffness() > 0 && racket.getPrice() > 0) {
                repository.save(racket);
                recordsNumber++;
            }
        }
        if (recordsNumber > 0) {
            return recordsNumber;
        } else {
            return -1;
        }
    }

    @PutMapping("/{id}")
    int update(@PathVariable int id, @RequestBody Racket racket) {
        Racket oldRacket = repository.findById(id).orElse(null);
        if (oldRacket != null && racket.getStrungWeight() > 0
                && racket.getBalance() > 0 && racket.getLength() > 0
                && racket.getHeadSize() > 0 && racket.getStiffness() > 0
                && racket.getPrice() > 0) {
            oldRacket.setName(racket.getName());
            oldRacket.setDescription(racket.getDescription());
            oldRacket.setImage(racket.getImage());
            oldRacket.setStrungWeight(racket.getStrungWeight());
            oldRacket.setBalance(racket.getBalance());
            oldRacket.setLength(racket.getLength());
            oldRacket.setHeadSize(racket.getHeadSize());
            oldRacket.setStringPattern(racket.getStringPattern());
            oldRacket.setBeamWidth(racket.getBeamWidth());
            oldRacket.setStiffness(racket.getStiffness());
            oldRacket.setPrice(racket.getPrice());
            repository.save(oldRacket);
            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    int partiallyUpdate(@PathVariable int id, @RequestBody Racket racket) {
        Racket oldRacket = repository.findById(id).orElse(null);
        if (oldRacket != null) {
            if (racket.getName() != null) {
                oldRacket.setName(racket.getName());
            }
            if (racket.getDescription() != null) {
                oldRacket.setDescription(racket.getDescription());
            }
            if (racket.getImage() != null) {
                oldRacket.setImage(racket.getImage());
            }
            if (racket.getStrungWeight() > 0) {
                oldRacket.setStrungWeight(racket.getStrungWeight());
            }
            if (racket.getBalance() > 0) {
                oldRacket.setBalance(racket.getBalance());
            }
            if (racket.getLength() > 0) {
                oldRacket.setLength(racket.getLength());
            }
            if (racket.getHeadSize() > 0) {
                oldRacket.setHeadSize(racket.getHeadSize());
            }
            if (racket.getStringPattern() != null) {
                oldRacket.setStringPattern(racket.getStringPattern());
            }
            if (racket.getBeamWidth() != null) {
                oldRacket.setBeamWidth(racket.getBeamWidth());
            }
            if (racket.getStiffness() > 0) {
                oldRacket.setStiffness(racket.getStiffness());
            }
            if (racket.getPrice() > 0) {
                oldRacket.setPrice(racket.getPrice());
            }
            repository.save(oldRacket);
            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("")
    int destroyAll() {
        repository.deleteAll();
        return 1;
    }

    @DeleteMapping("/{id}")
    int destroy(@PathVariable int id) {
        Racket oldRacket = repository.findById(id).orElse(null);
        if (oldRacket != null) {
            repository.deleteById(id);
            return 1;
        } else {
            return -1;
        }
    }
}
