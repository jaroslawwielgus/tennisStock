package com.example.fedel.restapi.ball;

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
@RequestMapping("/balls")
public class BallController {

    @Autowired
    private BallRepository repository;

    @GetMapping("")
    List<Ball> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Ball findOne(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("")
    Ball create(@RequestBody Ball ball) {
        return repository.save(ball);
    }

    @PutMapping("/{id}")
    Ball update(@PathVariable int id, @RequestBody Ball ball) {
        Ball oldBall = repository.findById(id).orElse(null);
        // System.out.println(ball.getName());
        oldBall.setName(ball.getName());
        oldBall.setDescription(ball.getDescription());
        oldBall.setSurface(ball.getSurface());
        oldBall.setBallType(ball.getBallType());
        oldBall.setBallClass(ball.getBallClass());
        oldBall.setQuantity(ball.getQuantity());
        oldBall.setPrice(ball.getPrice());
        return repository.save(oldBall);
    }

    @PatchMapping("/{id}")
    Ball partiallyUpdate(@PathVariable int id, @RequestBody Ball ball) {
        Ball oldBall = repository.findById(id).orElse(null);
        // System.out.println(ball.getName());
        if (ball.getName() != null) {
            oldBall.setName(ball.getName());
        }
        if (ball.getDescription() != null) {
            oldBall.setDescription(ball.getDescription());
        }
        if (ball.getSurface() != null) {
            oldBall.setSurface(ball.getSurface());
        }
        if (ball.getBallType() != null) {
            oldBall.setBallType(ball.getBallType());
        }
        if (ball.getBallClass() != null) {
            oldBall.setBallClass(ball.getBallClass());
        }
        if (ball.getQuantity() > 0) {
            oldBall.setQuantity(ball.getQuantity());
        }
        if (ball.getPrice() > 0) {
            oldBall.setPrice(ball.getPrice());
        }
        return repository.save(oldBall);
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
