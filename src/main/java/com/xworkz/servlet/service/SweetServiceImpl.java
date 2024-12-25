package com.xworkz.servlet.service;

import com.xworkz.servlet.dto.SweetFormDto;
import com.xworkz.servlet.repository.SweetRepository;
import com.xworkz.servlet.repository.SweetRepositoryImpl;

public class SweetServiceImpl implements SweetService{
    private SweetRepository sweetRepository = new SweetRepositoryImpl();


    @Override
    public boolean save(SweetFormDto dto) {
        System.out.println("saved");
        boolean result =sweetRepository.save(dto);
        return result;
    }
}
