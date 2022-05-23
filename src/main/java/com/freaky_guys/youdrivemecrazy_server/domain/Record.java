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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "animal_kill_count", nullable = false)
    private Integer animalKillCount;

    @Column(name = "pedestrian_kill_count", nullable = false)
    private Integer pedestrianKillCount;

    @Column(name = "car_accident_count", nullable = false)
    private Integer carAccidentCount;

    @Column(name = "illegal_lane_change_count", nullable = false)
    private Integer illegalLaneChangeCount;

    @Column(name = "signal_violation_count", nullable = false)
    private Integer signalViolationCount;

    @Column(name = "center_line_violation_count", nullable = false)
    private Integer centerLineViolationCount;

    @Column(name = "off_path_count", nullable = false)
    private Integer offPathCount;

    @Column(name = "max_speed", nullable = false)
    private Integer maxSpeed;

    @Column(name = "wiper_count", nullable = false)
    private Integer wiperCount;

    @Column(name = "klaxon_count", nullable = false)
    private Integer klaxonCount;

    @Column(name = "clear_count", nullable = false)
    private Integer clearCount;

    @Column(name = "min_clear_time", nullable = false)
    private Integer minClearTime;

    @Column(name = "achievement_count", nullable = false)
    private Integer achievementCount;
}
