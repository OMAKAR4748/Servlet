package com.xworkz.servlet.repository;

import com.xworkz.servlet.dto.SweetFormDto;

public interface SweetRepository {
    boolean save(SweetFormDto sweetFormDto);
}
