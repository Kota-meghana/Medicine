package com.edubridge.medicine.model;

import java.sql.Date;

public class Medicine {
      private int medicine_id;
      private String medicine_name;
      private String manufacture_name;
      private int medicine_price;
      private String expiry_date;
      
	public int getMedicine_id() {
		return medicine_id;
	}
	public void setMedicine_id(int medicine_id) {
		this.medicine_id = medicine_id;
	}
	public String getMedicine_name() {
		return medicine_name;
	}
	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}
	public String getManufacture_name() {
		return manufacture_name;
	}
	public void setManufacture_name(String manufacture_name) {
		this.manufacture_name = manufacture_name;
	}
	public int getMedicine_price() {
		return medicine_price;
	}
	public void setMedicine_price(int medicine_price) {
		this.medicine_price = medicine_price;
	}
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}
	public String getExpiry_date() {
		return expiry_date;
	}
	
      
      
}




