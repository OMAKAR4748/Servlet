package com.xworkz.servlet.service;

import com.xworkz.servlet.dto.MilkFormDto;
import com.xworkz.servlet.repository.MilkRepository;
import com.xworkz.servlet.repository.MilkRepositoryImpl;
import java.util.List;

public class MilkServiceImpl implements MilkService{
     private MilkRepository milkRepository = new MilkRepositoryImpl();


    @Override
    public boolean save(MilkFormDto milkFormDto) {
        System.out.println("saved");
        boolean result = milkRepository.save(milkFormDto);
        return result;
    }

    @Override
    public List<MilkFormDto> getAllMilkForms() {
        return MilkService.super.getAllMilkForms();
    }
}
