package com.xworkz.servlet.repository;

import com.xworkz.servlet.dto.MilkFormDto;

public interface MilkRepository {
    boolean save(MilkFormDto milkFormDto);
}
