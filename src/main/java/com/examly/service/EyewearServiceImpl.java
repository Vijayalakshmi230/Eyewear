package com.examly.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examly.entity.Eyewear;
import com.examly.util.DBConnectionUtil;

public class EyewearServiceImpl implements EyewearService {

    @Override
    public String addEyewear(Eyewear eyewear) {
        try {
            String sql = "insert into Eye (brand,frameType,price,gender,stock) values (?,?,?,?,?)";
            Connection conn = DBConnectionUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,eyewear.getBrand());
            stmt.setString(2,eyewear.getFrameType());
            stmt.setDouble(3,eyewear.getPrice());
            stmt.setString(4,eyewear.getGender());
            stmt.setInt(5,eyewear.getStock());

            int rows = stmt.executeUpdate();
            return rows > 0 ? "Eyewear added sucessfully" : "Failed to add Eyewear";
        } catch (SQLException e) {
            return "Error occired while adding to the database";
        }
    }

    @Override
    public String updateEyewear(Eyewear eyewear) {
        try {
            String sql = "update Eye set brand = ?, frameType = ?, price = ?,gender = ?,stock=? where eyewearId = ?";
            Connection conn = DBConnectionUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,eyewear.getBrand());
            stmt.setString(2,eyewear.getFrameType());
            stmt.setDouble(3,eyewear.getPrice());
            stmt.setString(4,eyewear.getGender());
            stmt.setInt(5,eyewear.getStock());
            stmt.setInt(6,eyewear.getEyewearId());            

            int rows = stmt.executeUpdate();
            return rows > 0 ? "Eyewear updated sucessfully" : "Failed to update Eyewear";
        } catch (SQLException e) {
            return "Error occired while updating to the database";
        }
    }

    @Override
    public String deleteEyewear(int eyewearId) {
        try {
            String sql = "Delete from Eye where eyewearId = ?";
            Connection conn = DBConnectionUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,eyewearId);       

            int rows = stmt.executeUpdate();
            return rows > 0 ? "Eyewear deleted sucessfully" : "Failed to delete Eyewear";
        } catch (SQLException e) {
            return "Error occired while deleting to the database";
        }
    }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public Eyewear getEyewearById(int eyewearId) {
        Eyewear eyewear = null;
        try {
            String sql = "select * from Eye where eyewearId = ?";
            Connection conn = DBConnectionUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,eyewearId);
            ResultSet rows = stmt.executeQuery();
            while(rows.next()){
                eyewear = new Eyewear(
                    rows.getInt("eyewearId"),
                    rows.getString("brand"),
                    rows.getString("frameType"),
                    rows.getDouble("price"),
                    rows.getString("gender"),
                    rows.getInt("stock")
                );
            }

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eyewear;
    }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public List<Eyewear> getAllEyewear() {
        List<Eyewear> eyewears = new ArrayList<>();
        try {
            String sql = "select * from Eye";
            Connection conn = DBConnectionUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rows = stmt.executeQuery();
            while(rows.next()){
                Eyewear eyewear = new Eyewear(
                    rows.getInt("eyewearId"),
                    rows.getString("brand"),
                    rows.getString("frameType"),
                    rows.getDouble("price"),
                    rows.getString("gender"),
                    rows.getInt("stock")
                );
                eyewears.add(eyewear);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eyewears;
    }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public Eyewear searchByBrand(String brand) {        
        Eyewear eyewear = null;
        try {
            String sql = "select * from Eye where brand like ?";
            Connection conn = DBConnectionUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,"%"+brand+"%");
            ResultSet rows = stmt.executeQuery();
            while(rows.next()){
               eyewear = new Eyewear(
                    rows.getInt("eyewearId"),
                    rows.getString("brand"),
                    rows.getString("frameType"),
                    rows.getDouble("price"),
                    rows.getString("gender"),
                    rows.getInt("stock")
                );
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eyewear;        
    }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public Eyewear filterBygender(String gender) {
        Eyewear eyewear = null;
        try {
            String sql = "select * from Eye where gender like ?";
            Connection conn = DBConnectionUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,"%"+gender+"%");
            ResultSet rows = stmt.executeQuery();
            while(rows.next()){
               eyewear = new Eyewear(
                    rows.getInt("eyewearId"),
                    rows.getString("brand"),
                    rows.getString("frameType"),
                    rows.getDouble("price"),
                    rows.getString("gender"),
                    rows.getInt("stock")
                );
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eyewear; 
    }
    
}
