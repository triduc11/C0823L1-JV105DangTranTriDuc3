package service;

import model.Manufactor;

import java.util.List;

public interface IManufactorService {
    List<Manufactor> getAll();
    Manufactor findByName(String name);
    boolean save(Manufactor manufactor);
}
