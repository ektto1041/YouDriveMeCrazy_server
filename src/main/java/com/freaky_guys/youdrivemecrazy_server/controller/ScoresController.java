package com.freaky_guys.youdrivemecrazy_server.controller;

import com.freaky_guys.youdrivemecrazy_server.dto.ScoresDto;
import com.freaky_guys.youdrivemecrazy_server.dto.ScoresResDto;
import com.freaky_guys.youdrivemecrazy_server.service.ScoresService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ScoresController {
    private final ScoresService scoresService;

    // 모든 점수 가져오는 api
    @GetMapping("scores")
    public ResponseEntity<Object> findAll() {
        ScoresResDto allScores = scoresService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(allScores);
    }

    // 점수 등록하는 api
    @PostMapping("scores/{player1}/{player2}/{clearTime}")
    public ResponseEntity<Object> insert(
            @PathVariable("player1") String player1,
            @PathVariable("player2") String player2,
            @PathVariable("clearTime") String clearTime) {
        ScoresDto scoresDto = scoresService.insert(player1, player2, clearTime);

        return ResponseEntity.status(HttpStatus.OK).body(scoresDto);
    }
}
