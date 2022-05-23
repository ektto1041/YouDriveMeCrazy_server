package com.freaky_guys.youdrivemecrazy_server.dto;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ScoresDto {
    private long scoresId;

    private String player1;
    private String player2;

    private float clearTime;

    // Method
}
