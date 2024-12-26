package com.xworkz.servlet.repository;

import com.xworkz.servlet.dto.MilkFormDto;

import java.util.Collections;
import java.util.List;

public interface MilkRepository {
    boolean save(MilkFormDto milkFormDto);

    default List<MilkFormDto> getAllMilkForms(){
       return Collections.emptyList();
    }
}
