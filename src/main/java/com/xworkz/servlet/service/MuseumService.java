package com.xworkz.servlet.service;

import com.xworkz.servlet.dto.MuseumTicketFormDto;
import java.util.List;

public interface MuseumService {
    boolean save(MuseumTicketFormDto museumTicketFormDto);

    default List<MuseumTicketFormDto> getAllMusemTicketForm() {
        return getAllMusemTicketForm();
    }

}
