package com.freaky_guys.youdrivemecrazy_server.service;

import com.freaky_guys.youdrivemecrazy_server.domain.Scores;
import com.freaky_guys.youdrivemecrazy_server.dto.ScoresDto;
import com.freaky_guys.youdrivemecrazy_server.repository.ScoresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScoresService {
    private final ScoresRepository scoresRepository;

    // 모든 점수 가져오는 메소드
    public List<ScoresDto> findAll() {
        List<Scores> allScores = scoresRepository.findAll();

        return allScores.stream().map(Scores::toDto).collect(Collectors.toList());
    }

    // 점수 등록하는 메소드
    public ScoresDto insert(String p1, String p2, int points) {
        Scores savedScores = scoresRepository.save(Scores.builder().player1(p1).player2(p2).points(points).build());

        return savedScores.toDto();
    }
}
