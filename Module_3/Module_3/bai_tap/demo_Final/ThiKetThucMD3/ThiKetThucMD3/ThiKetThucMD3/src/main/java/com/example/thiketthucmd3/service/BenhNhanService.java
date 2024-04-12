package com.example.thiketthucmd3.service;

import com.example.thiketthucmd3.dto.BenhAnDto;
import com.example.thiketthucmd3.repository.BenhAnRepository;
import com.example.thiketthucmd3.repository.IBenhAnRepository;

import java.util.List;

public class BenhNhanService implements IBenhNhanService{
    private IBenhAnRepository benhAnRepository = new BenhAnRepository();

    @Override
    public List<BenhAnDto> showlist() {
         return benhAnRepository.showList();
    }
}
