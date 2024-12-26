package com.xworkz.servlet.service;

import com.xworkz.servlet.dto.SweetFormDto;
import java.util.List;

public interface SweetService {

    boolean save(SweetFormDto dto);

    default List<SweetFormDto> getAllSweetForms() {
        return getAllSweetForms();
    }

}
