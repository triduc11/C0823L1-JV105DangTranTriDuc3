package com.example.thiketthucmd3.service;

import com.example.thiketthucmd3.dto.BenhAnDto;
import com.example.thiketthucmd3.model.BenhAn;
import com.example.thiketthucmd3.repository.BenhAnRepository;
import com.example.thiketthucmd3.repository.IBenhAnRepository;

import java.util.List;

public class BenhAnService implements IBenhAnService{
    private IBenhAnRepository benhAnRepository = new BenhAnRepository();
    @Override
    public List<BenhAnDto> showList() {
        return benhAnRepository.showList();
    }

    @Override
    public boolean updateBenhAn(BenhAnDto benhAnDto) {
        return benhAnRepository.updateBenhAn(benhAnDto);
    }

    @Override
    public boolean deleteBenhAn(int id) {
        return benhAnRepository.deleteBenhAn(id);
    }

    @Override
    public BenhAnDto selectBenhAn(int id) {
        return benhAnRepository.selectBenhAn(id);
    }
}
