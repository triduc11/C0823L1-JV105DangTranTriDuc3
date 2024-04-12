package repository.impl;

import dto.BenhAnDto;
import model.BenhAn;
import repository.ConnectDB;
import repository.IBenhAnRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepository implements IBenhAnRepository {
    private final String SEARCH = "select tt.id as id, tt.ma_benh_an ,tt.ma_benh_nhan , bn.ten_benh_nhan ,tt.ngay_nhap_vien, tt.ngay_ra_vien, tt.ly_do_nhap_vien from thong_tin_benh_an tt join benh_nhan bn on bn.ma_benh_nhan=tt.ma_benh_nhan where tt.ma_benh_an like concat('%',?,'%') and bn.ten_benh_nhan like concat('%',?,'%') ;";
    private final String GET_ALL = "select tt.id as id, tt.ma_benh_an ,tt.ma_benh_nhan , bn.ten_benh_nhan ,tt.ngay_nhap_vien, tt.ngay_ra_vien, tt.ly_do_nhap_vien from thong_tin_benh_an tt join benh_nhan bn on bn.ma_benh_nhan=tt.ma_benh_nhan ;";
    private final String INSERT1 = "insert into thong_tin_benh_an (ma_benh_an,ma_benh_nhan,ngay_nhap_vien,ngay_ra_vien,ly_do_nhap_vien) values \n" +
            "(?,?,?,?,?);";
    private final String UPDATE = "update thong_tin_benh_an set ma_benh_an=? , ma_benh_nhan=? ,ngay_nhap_vien=?,ngay_ra_vien=?,ly_do_nhap_vien=? where id=?;";
    private final String FIND_BY_ID = "select * from thong_tin_benh_an where id=?;";

    @Override
    public boolean add(BenhAn benhAn) {
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT1);
            preparedStatement.setString(1, benhAn.getMaBenhAn());
            preparedStatement.setString(2, benhAn.getMaBenhNhan());
            preparedStatement.setDate(3, benhAn.getNgayNhapVien());
            preparedStatement.setDate(4, benhAn.getNgayRaVien());
            preparedStatement.setString(5, benhAn.getLyDoNhapVien());
            int effectRow = preparedStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public List<BenhAnDto> getAll() {
        List<BenhAnDto> benhAnDtoList = new ArrayList<>();
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String maBenhAn = resultSet.getString("ma_benh_an");
                String maBenhNhan = resultSet.getString("ma_benh_nhan");
                String tenBenhNhan = resultSet.getString("ten_benh_nhan");
                Date ngayNhapVien = resultSet.getDate("ngay_nhap_vien");
                Date ngayRaVien = resultSet.getDate("ngay_ra_vien");
                String lyDoNhapVien = resultSet.getString("ly_do_nhap_vien");
                BenhAnDto benhAnDto = new BenhAnDto(id, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
                benhAnDtoList.add(benhAnDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return benhAnDtoList;
    }

    @Override
    public boolean update(BenhAn benhAn) {
        int updateId = benhAn.getId();
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, benhAn.getMaBenhAn());
            preparedStatement.setString(2, benhAn.getMaBenhNhan());
            preparedStatement.setDate(3, benhAn.getNgayNhapVien());
            preparedStatement.setDate(4, benhAn.getNgayRaVien());
            preparedStatement.setString(5, benhAn.getLyDoNhapVien());
            preparedStatement.setInt(6, updateId);
            int effectRow = preparedStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean delete(int id) {
        Connection connection = ConnectDB.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall("call delete_by_id(?);");
            callableStatement.setInt(1, id);
            int effectRow = callableStatement.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public BenhAn findById(int id) {
        BenhAn benhAn = null;
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maBenhAn = resultSet.getString("ma_benh_an");
                String maBenhNhan = resultSet.getString("ma_benh_nhan");
                Date ngayNhapVien = resultSet.getDate("ngay_nhap_vien");
                Date ngayRaVien = resultSet.getDate("ngay_ra_vien");
                String lyDoNhapVien = resultSet.getString("ly_do_nhap_vien");
                benhAn = new BenhAn(id, maBenhAn, maBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return benhAn;
    }

    @Override
    public List<BenhAnDto> search(String searchMaBenhAn, String searchTenBenhNhan) {
        List<BenhAnDto> benhAnDtoList = new ArrayList<>();
        Connection connection = ConnectDB.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, searchMaBenhAn);
            preparedStatement.setString(2, searchTenBenhNhan);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String maBenhAn = resultSet.getString("ma_benh_an");
                String maBenhNhan = resultSet.getString("ma_benh_nhan");
                String tenBenhNhan = resultSet.getString("ten_benh_nhan");
                Date ngayNhapVien = resultSet.getDate("ngay_nhap_vien");
                Date ngayRaVien = resultSet.getDate("ngay_ra_vien");
                String lyDoNhapVien = resultSet.getString("ly_do_nhap_vien");
                BenhAnDto benhAnDto = new BenhAnDto(id, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
                benhAnDtoList.add(benhAnDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return benhAnDtoList;
    }
}
