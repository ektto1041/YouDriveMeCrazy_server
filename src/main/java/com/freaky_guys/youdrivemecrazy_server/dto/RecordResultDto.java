package com.freaky_guys.youdrivemecrazy_server.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class RecordResultDto {
    private String playerName;

    private boolean animalKill = false;

    private boolean pedestrianKill = false;

    private boolean carAccident = false;

    private boolean illegalLaneChange = false;

    private boolean signalViolation = false;

    private boolean centerLineViolation = false;

    private boolean offPath = false;

    private boolean maxSpeed = false;

    private boolean wiperCount = false;

    private boolean klaxonCount = false;

    private boolean clearCount = false;

    private boolean minClearTime = false;

    private boolean achievementCount = false;

    public RecordResultDto(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return "RecordResultDto{" +
                "playerName='" + playerName + '\'' +
                ", animalKill=" + animalKill +
                ", pedestrianKill=" + pedestrianKill +
                ", carAccident=" + carAccident +
                ", illegalLaneChange=" + illegalLaneChange +
                ", signalViolation=" + signalViolation +
                ", centerLineViolation=" + centerLineViolation +
                ", offPath=" + offPath +
                ", maxSpeed=" + maxSpeed +
                ", wiperCount=" + wiperCount +
                ", klaxonCount=" + klaxonCount +
                ", clearCount=" + clearCount +
                ", minClearTime=" + minClearTime +
                ", achievementCount=" + achievementCount +
                '}';
    }
}