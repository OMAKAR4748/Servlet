package com.xworkz.servlet.service;

import com.xworkz.servlet.dto.CricketTournamentDto;
import com.xworkz.servlet.dto.MilkFormDto;

import java.util.List;

public interface CricketService {

    boolean save(CricketTournamentDto cricketTournamentDto);

    default List<CricketTournamentDto> getAllCricketForm()
    {
        return getAllCricketForm();
    }


}
