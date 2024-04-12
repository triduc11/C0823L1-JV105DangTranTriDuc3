package service.impl;

import dto.BenhAnDto;
import model.BenhAn;
import repository.IBenhAnRepository;
import repository.impl.BenhAnRepository;
import service.IBenhAnService;

import java.util.List;

public class BenhAnService implements IBenhAnService {
    private final IBenhAnRepository benhAnRepository=new BenhAnRepository();
    @Override
    public boolean add(BenhAn benhAn) {
        return benhAnRepository.add(benhAn);
    }

    @Override
    public List<BenhAnDto> getAll() {
        return benhAnRepository.getAll();
    }

    @Override
    public boolean update(BenhAn benhAn) {
        return benhAnRepository.update(benhAn);
    }

    @Override
    public boolean delete(int id) {
        return benhAnRepository.delete(id);
    }

    @Override
    public BenhAn findById(int id) {
        return benhAnRepository.findById(id);
    }

    @Override
    public List<BenhAnDto> search(String searchMaBenhAn, String searchTenBenhNhan) {
        return benhAnRepository.search(searchMaBenhAn,searchTenBenhNhan);
    }
}
