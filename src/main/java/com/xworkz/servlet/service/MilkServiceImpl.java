package com.xworkz.servlet.service;

import com.xworkz.servlet.dto.MilkFormDto;
import com.xworkz.servlet.repository.MilkRepository;
import com.xworkz.servlet.repository.MilkRepositoryImpl;

public class MilkServiceImpl implements MilkService{
     private MilkRepository milkRepository = new MilkRepositoryImpl();


    @Override
    public boolean save(MilkFormDto dto) {
        System.out.println("saved");
        boolean result = milkRepository.save(dto);
        return result;
    }
}
