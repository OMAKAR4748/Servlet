package com.xworkz.servlet.repository;

import com.xworkz.servlet.dto.MuseumTicketFormDto;

import java.util.Collections;
import java.util.List;

public interface MuseumRepository {
    boolean save(MuseumTicketFormDto museumTicketFormDto);

    default List<MuseumTicketFormDto> getAllMusemTicketForm()
    {
        return Collections.emptyList();
    }
}
