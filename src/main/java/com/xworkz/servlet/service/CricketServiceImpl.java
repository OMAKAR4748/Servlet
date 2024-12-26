package com.xworkz.servlet.service;

import com.xworkz.servlet.dto.CricketTournamentDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CricketServiceImpl implements CricketService{

    private CricketService cricketService = new CricketServiceImpl();


    @Override
    public boolean save(CricketTournamentDto cricketTournamentDto) {
        System.out.println("saved");
        cricketService.save(cricketTournamentDto);
        return true;
    }

    @Override
    public List<CricketTournamentDto> getAllCricketForm()
    {
        return CricketService.super.getAllCricketForm();
    }
}
