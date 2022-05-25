package com.freaky_guys.youdrivemecrazy_server.service;

import com.freaky_guys.youdrivemecrazy_server.domain.Record;
import com.freaky_guys.youdrivemecrazy_server.dto.RecordDto;
import com.freaky_guys.youdrivemecrazy_server.dto.RecordResultDto;
import com.freaky_guys.youdrivemecrazy_server.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RecordService {
    private final RecordRepository recordRepository;

    @Transactional
    public RecordResultDto insertRecord(RecordDto recordDto) {
        String playerName = recordDto.getPlayerName();

        Record foundRecord = recordRepository.findByPlayerName(playerName);
        RecordResultDto recordResultDto = new RecordResultDto(playerName);

        byte type = recordDto.getType();

        /**
         * 게임이 종료된 원인
         * 0 - 클리어
         * 1 - 동물 킬
         * 2 - 보행자 킬
         * 3 - 차 사고
         * 4 - 깜빡이 없이 차선 변경
         * 5 - 신호 위반(신호등)
         * 6 - 중앙선 침범
         * 7 - 길 벗어남
         */

        switch (type) {
            case 0:
                foundRecord.addClearCount();
                if(foundRecord.getClearCount() == 100) {
                    recordResultDto.setClearCount(true);
                    foundRecord.addAchievementCount();
                }
                break;
            case 1:
                foundRecord.addAnimalKillCount();
                if(foundRecord.getAnimalKillCount() == 100) {
                    recordResultDto.setAnimalKill(true);
                    foundRecord.addAchievementCount();
                }
                break;
            case 2:
                foundRecord.addPedestrianKillCount();
                if(foundRecord.getPedestrianKillCount() == 100) {
                    recordResultDto.setPedestrianKill(true);
                    foundRecord.addAchievementCount();
                }
                break;
            case 3:
                foundRecord.addCarAccidentCount();
                if(foundRecord.getCarAccidentCount() == 100) {
                    recordResultDto.setCarAccident(true);
                    foundRecord.addAchievementCount();
                }
                break;
            case 4:
                foundRecord.addIllegalLaneChangeCount();
                if(foundRecord.getIllegalLaneChangeCount() == 100) {
                    recordResultDto.setIllegalLaneChange(true);
                    foundRecord.addAchievementCount();
                }
                break;
            case 5:
                foundRecord.addSignalViolationCount();
                if(foundRecord.getSignalViolationCount() == 100) {
                    recordResultDto.setSignalViolation(true);
                    foundRecord.addAchievementCount();
                }
                break;
            case 6:
                foundRecord.addCenterLineViolationCount();
                if(foundRecord.getCenterLineViolationCount() == 100) {
                    recordResultDto.setCenterLineViolation(true);
                    foundRecord.addAchievementCount();
                }
                break;
            case 7:
                foundRecord.addOffPathCount();
                if(foundRecord.getOffPathCount() == 100) {
                    recordResultDto.setOffPath(true);
                    foundRecord.addAchievementCount();
                }
        }

        // 최대 속도 업적
        int nowMaxSpeed = foundRecord.getMaxSpeed();
        int newMaxSpeed = recordDto.getMaxSpeed();
        if(newMaxSpeed > nowMaxSpeed) {
            foundRecord.setMaxSpeed(newMaxSpeed);

            if(nowMaxSpeed < 240 && newMaxSpeed >= 240) {
                recordResultDto.setMaxSpeed(true);
                foundRecord.addAchievementCount();
            }
        }

        // 와이퍼 횟수
        int nowWiperCount = foundRecord.getWiperCount();
        foundRecord.addWiperCount(recordDto.getWiperCount());
        if(nowWiperCount < 100 && foundRecord.getWiperCount() >= 100) {
            recordResultDto.setWiperCount(true);
            foundRecord.addAchievementCount();
        }

        // 클락션 횟수
        int nowKlaxonCount = foundRecord.getKlaxonCount();
        foundRecord.addKlaxonCount(recordDto.getKlaxonCount());
        if(nowKlaxonCount < 100 && foundRecord.getKlaxonCount() >= 100) {
            recordResultDto.setKlaxonCount(true);
            foundRecord.addAchievementCount();
        }

        // 클리어 타임 1분 이하
        float nowMinClearTime = foundRecord.getMinClearTime();
        float newClearTime = recordDto.getClearTime();
        if(newClearTime < nowMinClearTime) foundRecord.setMinClearTime(newClearTime);
        if(nowMinClearTime > 60f && newClearTime <= 60f) {
            recordResultDto.setMinClearTime(true);
            foundRecord.addAchievementCount();
        }

        // 모든 업적 클리어
        if(foundRecord.getAchievementCount() == 12) {
            recordResultDto.setAchievementCount(true);
            foundRecord.addAchievementCount();
        }

        return recordResultDto;
    }
}
