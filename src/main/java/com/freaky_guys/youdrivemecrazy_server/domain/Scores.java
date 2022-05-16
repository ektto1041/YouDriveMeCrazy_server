package com.freaky_guys.youdrivemecrazy_server.domain;

import com.freaky_guys.youdrivemecrazy_server.dto.ScoresDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "SCORES")
public class Scores {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scores_id")
    private long scoresId;

    @Column(name = "player1", nullable = false)
    private String player1;

    @Column(name = "player2", nullable = false)
    private String player2;

    @Column(name = "points", nullable = false)
    private int points;

    // Method
    public ScoresDto toDto() {
        return new ScoresDto(scoresId, player1, player2, points);
    }
}
