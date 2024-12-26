package com.xworkz.servlet.service;

import com.xworkz.servlet.dto.MilkFormDto;

import java.util.List;

public interface MilkService {

    boolean save(MilkFormDto dto);

    default  List<MilkFormDto> getAllMilkForms()
    {
        return getAllMilkForms();
    }

}
