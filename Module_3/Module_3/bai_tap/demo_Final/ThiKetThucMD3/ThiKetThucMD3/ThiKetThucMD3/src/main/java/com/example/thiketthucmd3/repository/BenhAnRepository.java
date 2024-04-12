package com.example.thiketthucmd3.repository;

import com.example.thiketthucmd3.dto.BenhAnDto;
import com.example.thiketthucmd3.model.BenhAn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepository implements IBenhAnRepository{
    private static final String SHOW_LIST = "select ba.* ,bn.ten_benh_nhan from benh_an ba\n" +
            "join benh_nhan bn on ba.ma_benh_nhan = bn.ma_benh_nhan where ba.trang_thai = 0;" ;
    private static final String DELETE = "UPDATE benh_an SET trang_thai = 1 WHERE id = ?;";
    private static final String SELECT = "select ba.* ,bn.ten_benh_nhan from benh_an ba\n" +
            "join benh_nhan bn on ba.ma_benh_nhan = bn.ma_benh_nhan where id = ? and trang_thai = 0;" ;
    private static final String UPDATE ="UPDATE quan_ly_benh_an.benh_an ba\n" +
            "join benh_nhan  bn on ba.ma_benh_nhan = bn.ma_benh_nhan\n" +
            "SET ba.ngay_nhap_vien = ?, ba.ngay_ra_vien = ?, ba.ly_do_nhap_vien =?, bn.ten_benh_nhan = ? WHERE (id = ? );";
    @Override
    public List<BenhAnDto> showList() {
        List<BenhAnDto> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW_LIST);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String maBenhAn = resultSet.getString("ma_benh_an");
                String maBenhNhan = resultSet.getString("ma_benh_nhan");
                Date ngayNhapVien = resultSet.getDate("ngay_nhap_vien");
                Date ngayRaVien = resultSet.getDate("ngay_ra_vien");
                String lyDoNhapVien = resultSet.getString("ly_do_nhap_vien");
                String tenBenhNhan = resultSet.getString("ten_benh_nhan");
                list.add(new BenhAnDto(id,maBenhAn,maBenhNhan,ngayNhapVien,ngayRaVien,lyDoNhapVien,tenBenhNhan));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean updateBenhAn(BenhAnDto benhAnDto) {
        boolean rowUpdate = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setDate(1,benhAnDto.getNgayNhapVien());
            preparedStatement.setDate(2,benhAnDto.getNgayRaVien());
            preparedStatement.setString(3,benhAnDto.getLyDoNhapVien());
            preparedStatement.setString(4,benhAnDto.getTenBenhNhan());
            preparedStatement.setInt(5,benhAnDto.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
    }

    @Override
    public boolean deleteBenhAn(int id) {
        boolean rowDelele = false;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,id);
            rowDelele = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelele ;
    }

    @Override
    public BenhAnDto selectBenhAn(int id) {
        BenhAnDto benhAnDto = null;
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id1 = resultSet.getInt("id");
                String maBenhAn = resultSet.getString("ma_benh_an");
                String maBenhNhan = resultSet.getString("ma_benh_nhan");
                Date ngayNhapVien = resultSet.getDate("ngay_nhap_vien");
                Date ngayRaVien = resultSet.getDate("ngay_ra_vien");
                String lyDoNhapVien = resultSet.getString("ly_do_nhap_vien");
                String tenBenhNhan = resultSet.getString("ten_benh_nhan");
                benhAnDto = new BenhAnDto(id1,maBenhAn,maBenhNhan,ngayNhapVien,ngayRaVien,lyDoNhapVien,tenBenhNhan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return benhAnDto;
    }
}
