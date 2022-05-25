package com.freaky_guys.youdrivemecrazy_server.repository;

import com.freaky_guys.youdrivemecrazy_server.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    Record findByPlayerName(String playerName);
}
