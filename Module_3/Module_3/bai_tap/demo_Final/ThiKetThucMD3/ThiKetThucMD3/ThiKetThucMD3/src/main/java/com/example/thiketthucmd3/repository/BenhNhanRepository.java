package com.example.thiketthucmd3.repository;

import com.example.thiketthucmd3.model.BenhNhan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanRepository implements IBenhNhanRepository{
    private static final String SHOW = "SELECT * FROM quan_ly_benh_an.benh_nhan;";
    @Override
    public List<BenhNhan> showlist() {
        List<BenhNhan> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SHOW);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String maBenhNhan = resultSet.getString("ma_benh_nhan");
                String tenBenhNhan = resultSet.getString("ten_benh_nhan");
                list.add(new BenhNhan(maBenhNhan,tenBenhNhan));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
