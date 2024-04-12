package repository;

import dto.BenhAnDto;
import model.BenhAn;

import java.util.List;

public interface IBenhAnRepository {
    boolean add (BenhAn entity) ;
    List<BenhAnDto> getAll();
    boolean update(BenhAn entity);
    boolean delete (int id);
    BenhAn findById(int id);
    List<BenhAnDto> search (String searchMaBenhAn,String searchTenBenhNhan);
}