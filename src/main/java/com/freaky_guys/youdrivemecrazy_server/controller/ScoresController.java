package com.freaky_guys.youdrivemecrazy_server.controller;

import com.freaky_guys.youdrivemecrazy_server.dto.ScoresDto;
import com.freaky_guys.youdrivemecrazy_server.dto.ScoresResDto;
import com.freaky_guys.youdrivemecrazy_server.service.ScoresService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScoresController {
    private final ScoresService scoresService;

    // 모든 점수 가져오는 api
    @GetMapping("scores")
    public ResponseEntity<Object> findAll() {
        ScoresResDto allScores = scoresService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(allScores);
    }

    // 점수 등록하는 api
    @PostMapping(value="scores", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insert(@RequestBody ScoresDto scoresDto) {
        ScoresDto result = scoresService.insert(scoresDto);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
