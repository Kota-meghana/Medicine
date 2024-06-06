package com.edubridge.medicine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.medicine.model.Medicine;
import com.edubridge.medicine.util.DBUtils;

public class MedicineDaoImpl implements MedicineDao {
      static Connection con = DBUtils.getConnection();

	@Override
	public int addMedicine(Medicine c) {
		String INSERT_QUERY = "insert into medicine(name,manufacture_name,price,expiry_date) values(?,?,?,?)";
		int status = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
			ps.setString(1, c.getMedicine_name());
			ps.setString(2, c.getManufacture_name());
			ps.setInt(3, c.getMedicine_price());
			
			ps.setString(4, c.getExpiry_date());
			status = ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Medicine> findContacts() {
		String SELECT_QUERY = "select * from medicine";
		List<Medicine> medicineList = new ArrayList<>();
		
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_QUERY);
			ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Medicine c = new Medicine();
					c.setMedicine_id(rs.getInt("Id"));
					c.setMedicine_name(rs.getString("name"));
					c.setManufacture_name(rs.getString("manufacture_name"));
					c.setMedicine_price(rs.getInt("price"));
					c.setExpiry_date(rs.getString("expiry_date"));
					medicineList.add(c);
				}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return medicineList;										
	}

	@Override
	public Medicine findMedicineByName(String name) {
		String SELECT_QUERY = "select * from medicine where name=?";
		 Medicine c= null;
		 try {
			 PreparedStatement ps= con.prepareStatement(SELECT_QUERY);
			 ps.setString(1, name);
			 
			 ResultSet rs = ps.executeQuery();
			 
			 if(rs.next()) {
				 c = new Medicine();
				 c.setMedicine_id(rs.getInt("id"));
				 c.setMedicine_name(rs.getString("name"));
				 c.setManufacture_name(rs.getString("manufacture_name"));
				 c.setMedicine_price(rs.getInt("price"));
				 c.setExpiry_date(rs.getString("expiry_date"));
				 
				 
			 }
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
		return c;
	}

	@Override
	public int upadteMedicine(Medicine c) {
		String UPDATE_QUERY = "update medicine set name=?,manufacture_name=?,price=?,expiry_date=?";
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
			ps.setString(1, c.getMedicine_name());
			ps.setString(2, c.getManufacture_name());
			ps.setInt(3, c.getMedicine_price());
			ps.setString(4, c.getExpiry_date());
	
			status = ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteMedicineByName(String name) {
		String DELETE_QUERY = "delete from medicine where name=?";
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			ps.setString(1, name);
			status = ps.executeUpdate();
						}
							catch (SQLException e) {
								e.printStackTrace();
							}
							return status;
		
	}

	@Override
	public void deleteallMedicine() {
		String DELETE_QUERY = "delete from medicine";
		
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			ps.executeUpdate();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	
      
}
