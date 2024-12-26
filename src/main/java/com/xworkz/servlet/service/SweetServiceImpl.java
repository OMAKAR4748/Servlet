package com.xworkz.servlet.service;

import com.xworkz.servlet.dto.SweetFormDto;
import com.xworkz.servlet.repository.SweetRepository;
import com.xworkz.servlet.repository.SweetRepositoryImpl;
import java.util.List;

public class SweetServiceImpl implements SweetService {
    private SweetRepository sweetRepository = new SweetRepositoryImpl();

    @Override
    public boolean save(SweetFormDto sweetFormDto) {
        return sweetRepository.save(sweetFormDto);
    }

    @Override
    public List<SweetFormDto> getAllSweetForms() {
        return sweetRepository.getAllSweetForms();
    }
}
