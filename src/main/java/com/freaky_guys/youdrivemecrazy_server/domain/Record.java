package com.freaky_guys.youdrivemecrazy_server.domain;

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
    private Integer playerName;

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

}
