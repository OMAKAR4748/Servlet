package com.xworkz.servlet.service;

import com.xworkz.servlet.dto.MuseumTicketFormDto;
import com.xworkz.servlet.dto.SweetFormDto;
import com.xworkz.servlet.repository.MuseumRepository;
import com.xworkz.servlet.repository.MuseumRepositoryImpl;
import java.util.List;

public class MuseumServiceImpl implements MuseumService {
    private MuseumRepository museumRepository = new MuseumRepositoryImpl();

    @Override
    public boolean save(MuseumTicketFormDto museumTicketFormDto) {
        System.out.println("saved");
        museumRepository.save(museumTicketFormDto);
        return true;
    }

    @Override
    public List<MuseumTicketFormDto> getAllMusemTicketForm() {
        return MuseumService.super.getAllMusemTicketForm();
    }
}
