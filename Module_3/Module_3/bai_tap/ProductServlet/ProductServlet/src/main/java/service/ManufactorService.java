package service;

import model.Manufactor;
import repository.IManufactorRepository;
import repository.ManufactorRepsitory;

import java.util.List;

public class ManufactorService implements  IManufactorService{
    private IManufactorRepository manufactorRepository = new ManufactorRepsitory();
    @Override
    public List<Manufactor> getAll() {
        return manufactorRepository.findAll();
    }

    @Override
    public boolean save(Manufactor manufactor) {
        return manufactorRepository.save(manufactor);
    }

    public Manufactor findByName(String name) {
        return manufactorRepository.findByName(name);
    }
}
