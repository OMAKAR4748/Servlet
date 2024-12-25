package com.xworkz.servlet.repository;

import com.xworkz.servlet.dto.CricketTournamentDto;

public interface CricketTournamentRepository {
    boolean save(CricketTournamentDto cricketTournamentDto);
}
