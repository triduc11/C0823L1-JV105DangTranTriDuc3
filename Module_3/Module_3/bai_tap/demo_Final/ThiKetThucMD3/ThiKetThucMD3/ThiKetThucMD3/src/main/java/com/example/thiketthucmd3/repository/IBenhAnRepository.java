package com.example.thiketthucmd3.repository;

import com.example.thiketthucmd3.dto.BenhAnDto;
import com.example.thiketthucmd3.model.BenhAn;

import java.util.List;

public interface IBenhAnRepository {
    List<BenhAnDto> showList();
    boolean updateBenhAn(BenhAnDto benhAnDto);
    boolean deleteBenhAn(int id);
    BenhAnDto selectBenhAn(int id);
}
