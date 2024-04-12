package service.impl;

import model.BenhNhan;
import repository.IBenhNhanRepository;
import repository.impl.BenhNhanRepository;
import service.IBenhNhanService;

import java.util.List;

public class BenhNhanService implements IBenhNhanService {
    private final IBenhNhanRepository benhNhanRepository=new BenhNhanRepository();
    @Override
    public List<BenhNhan> findAll() {
        return benhNhanRepository.findAll();
    }
}
