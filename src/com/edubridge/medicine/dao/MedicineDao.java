package com.edubridge.medicine.dao;

import java.util.List;

import com.edubridge.medicine.model.Medicine;



public interface MedicineDao {
	int addMedicine (Medicine c);
	List<Medicine> findContacts();
	Medicine findMedicineByName(String name);
	int upadteMedicine(Medicine c);
	int deleteMedicineByName(String name);
	void deleteallMedicine();
	

}
