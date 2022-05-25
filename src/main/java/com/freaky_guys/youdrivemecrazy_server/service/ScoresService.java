package com.freaky_guys.youdrivemecrazy_server.service;

import com.freaky_guys.youdrivemecrazy_server.domain.Scores;
import com.freaky_guys.youdrivemecrazy_server.dto.ScoresDto;
import com.freaky_guys.youdrivemecrazy_server.dto.ScoresResDto;
import com.freaky_guys.youdrivemecrazy_server.repository.ScoresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
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
    public ScoresResDto findAll() {
        List<Scores> allScores = scoresRepository.findAll(Sort.by(Sort.Direction.ASC, "clearTime"));

        return new ScoresResDto(allScores.stream().map(Scores::toDto).collect(Collectors.toList()));
    }

    // 점수 등록하는 메소드
    @Transactional
    public ScoresDto insert(ScoresDto scoresDto) {
        Scores scores = Scores.builder().scoresId(0L).player1(scoresDto.getPlayer1()).player2(scoresDto.getPlayer2()).clearTime(scoresDto.getClearTime()).build();
        System.out.println(scores.getScoresId());

        Scores savedScores = scoresRepository.save(scores);

        return savedScores.toDto();
    }
}
