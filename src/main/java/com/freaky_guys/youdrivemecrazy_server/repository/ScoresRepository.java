package com.freaky_guys.youdrivemecrazy_server.repository;

import com.freaky_guys.youdrivemecrazy_server.domain.Scores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoresRepository extends JpaRepository<Scores, Long> {
//    List<Scores> findAllOrderByClearTimeAsc();
}
