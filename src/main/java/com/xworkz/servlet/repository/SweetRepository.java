package com.xworkz.servlet.repository;

import com.xworkz.servlet.dto.SweetFormDto;

import java.util.Collections;
import java.util.List;

public interface SweetRepository {
    boolean save(SweetFormDto sweetFormDto);

    default List<SweetFormDto> getAllSweetForms()
    {
        return Collections.emptyList();
    }
}
