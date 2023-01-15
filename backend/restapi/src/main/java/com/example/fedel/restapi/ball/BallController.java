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
    int create(@RequestBody List<Ball> balls) {
        int recordsNumber = 0;
        for (Ball ball : balls) {
            if (ball.getQuantity() > 0 && ball.getPrice() > 0) {
                repository.save(ball);
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
    int update(@PathVariable int id, @RequestBody Ball ball) {
        Ball oldBall = repository.findById(id).orElse(null);
        if (oldBall != null && ball.getPrice() > 0
                && ball.getQuantity() > 0) {
            oldBall.setName(ball.getName());
            oldBall.setDescription(ball.getDescription());
            oldBall.setImage(ball.getImage());
            oldBall.setSurface(ball.getSurface());
            oldBall.setBallType(ball.getBallType());
            oldBall.setBallClass(ball.getBallClass());
            oldBall.setQuantity(ball.getQuantity());
            oldBall.setPrice(ball.getPrice());
            repository.save(oldBall);
            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    int partiallyUpdate(@PathVariable int id, @RequestBody Ball ball) {
        Ball oldBall = repository.findById(id).orElse(null);
        if (oldBall != null) {
            if (ball.getName() != null) {
                oldBall.setName(ball.getName());
            }
            if (ball.getDescription() != null) {
                oldBall.setDescription(ball.getDescription());
            }
            if (ball.getImage() != null) {
                oldBall.setImage(ball.getImage());
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
            repository.save(oldBall);
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
        Ball oldBall = repository.findById(id).orElse(null);
        if (oldBall != null) {
            repository.deleteById(id);
            return 1;
        } else {
            return -1;
        }
    }
}
