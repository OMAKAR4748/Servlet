package com.xworkz.servlet.repository;

import com.xworkz.servlet.dto.MuseumTicketFormDto;

public interface MuseumRepository {
    boolean save(MuseumTicketFormDto museumTicketFormDto);
}
