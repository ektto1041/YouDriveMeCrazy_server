package com.freaky_guys.youdrivemecrazy_server.controller;

import com.freaky_guys.youdrivemecrazy_server.dto.RecordDto;
import com.freaky_guys.youdrivemecrazy_server.dto.RecordResultDto;
import com.freaky_guys.youdrivemecrazy_server.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RecordController {
    private final RecordService recordService;

    @GetMapping(value="record/{playerName}")
    public ResponseEntity<Object> getRecord(@PathVariable("playerName") String playerName) {
        RecordResultDto result = recordService.getRecord(playerName);

        return ResponseEntity.ok(result);
    }

    @PostMapping(value="record", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertRecord(@RequestBody RecordDto recordDto) {
        RecordResultDto recordResultDto = recordService.insertRecord(recordDto);

        return ResponseEntity.ok(recordResultDto);
    }
}
