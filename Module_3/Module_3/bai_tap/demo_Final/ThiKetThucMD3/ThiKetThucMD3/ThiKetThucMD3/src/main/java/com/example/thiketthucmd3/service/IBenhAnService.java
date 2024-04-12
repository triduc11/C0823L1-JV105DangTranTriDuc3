package com.example.thiketthucmd3.service;

import com.example.thiketthucmd3.dto.BenhAnDto;
import com.example.thiketthucmd3.model.BenhAn;

import java.util.List;

public interface IBenhAnService {
    List<BenhAnDto> showList();
    boolean updateBenhAn(BenhAnDto benhAnDto);
    boolean deleteBenhAn(int id);
    BenhAnDto selectBenhAn(int id);
}
