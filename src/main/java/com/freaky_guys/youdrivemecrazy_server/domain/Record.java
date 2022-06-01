package com.freaky_guys.youdrivemecrazy_server.domain;

import com.freaky_guys.youdrivemecrazy_server.dto.RecordResultDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "RECORDS")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private long recordId;

    @Column(name = "player_name", nullable = false)
    private String playerName;

    @Column(name = "animal_kill_count", nullable = false)
    private Integer animalKillCount;

    public void addAnimalKillCount() { animalKillCount++; }

    @Column(name = "pedestrian_kill_count", nullable = false)
    private Integer pedestrianKillCount;

    public void addPedestrianKillCount() { pedestrianKillCount++; }

    @Column(name = "car_accident_count", nullable = false)
    private Integer carAccidentCount;

    public void addCarAccidentCount() { carAccidentCount++; }

    @Column(name = "illegal_lane_change_count", nullable = false)
    private Integer illegalLaneChangeCount;

    public void addIllegalLaneChangeCount() { illegalLaneChangeCount++; }

    @Column(name = "signal_violation_count", nullable = false)
    private Integer signalViolationCount;

    public void addSignalViolationCount() { signalViolationCount++; }

    @Column(name = "center_line_violation_count", nullable = false)
    private Integer centerLineViolationCount;

    public void addCenterLineViolationCount() { centerLineViolationCount++; }

    @Column(name = "off_path_count", nullable = false)
    private Integer offPathCount;

    public void addOffPathCount() { offPathCount++; }

    @Column(name = "max_speed", nullable = false)
    private Integer maxSpeed;

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Column(name = "wiper_count", nullable = false)
    private Integer wiperCount;

    public void addWiperCount(int count) {
        wiperCount += count;
    }

    @Column(name = "klaxon_count", nullable = false)
    private Integer klaxonCount;

    public void addKlaxonCount(int count) {
        klaxonCount += count;
    }

    @Column(name = "clear_count", nullable = false)
    private Integer clearCount;

    public void addClearCount() { clearCount++; }

    @Column(name = "min_clear_time", nullable = false)
    private Float minClearTime;

    public void setMinClearTime(Float minClearTime) {
        this.minClearTime = minClearTime;
    }

    @Column(name = "achievement_count", nullable = false)
    private Integer achievementCount;

    public void addAchievementCount() {
        achievementCount++;
    }

    public static Record create(String name) {
        return Record.builder().recordId(0).playerName(name)
                .animalKillCount(0)
                .pedestrianKillCount(0)
                .carAccidentCount(0)
                .illegalLaneChangeCount(0)
                .signalViolationCount(0)
                .centerLineViolationCount(0)
                .offPathCount(0)
                .maxSpeed(0)
                .wiperCount(0)
                .klaxonCount(0)
                .clearCount(0)
                .minClearTime(6000f)
                .achievementCount(0).build();
    }

    public RecordResultDto toResultDto() {
        RecordResultDto result = new RecordResultDto(this.playerName);

        if(animalKillCount >= 100) result.setAnimalKill(true);
        if(pedestrianKillCount >= 100) result.setPedestrianKill(true);
        if(carAccidentCount >= 100) result.setCarAccident(true);
        if(illegalLaneChangeCount >= 100) result.setIllegalLaneChange(true);
        if(signalViolationCount >= 100) result.setSignalViolation(true);
        if(centerLineViolationCount >= 100) result.setCenterLineViolation(true);
        if(offPathCount >= 100) result.setOffPath(true);
        if(maxSpeed >= 240) result.setMaxSpeed(true);
        if(wiperCount >= 100) result.setWiperCount(true);
        if(klaxonCount >= 100) result.setKlaxonCount(true);
        if(clearCount >= 100) result.setClearCount(true);
        if(minClearTime <= 60) result.setMinClearTime(true);
        if(achievementCount >= 12) result.setAchievementCount(true);

        return result;
    }
}
