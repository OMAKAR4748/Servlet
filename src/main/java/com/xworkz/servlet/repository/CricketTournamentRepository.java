package com.xworkz.servlet.repository;

import com.xworkz.servlet.dto.CricketTournamentDto;

import java.util.Collections;
import java.util.List;

public interface CricketTournamentRepository {
    boolean save(CricketTournamentDto cricketTournamentDto);

    default List<CricketTournamentDto> getAllCricketForm()
    {
        return Collections.emptyList();
    }
}
