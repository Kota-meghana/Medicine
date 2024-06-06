package com.edubridge.medicine.service;

import java.util.List;

import com.edubridge.medicine.model.Medicine;

public interface MedicineService {
     int addMedicine (Medicine c);
     List<Medicine> findMedicine();
     Medicine findMedicineByName(String name);
 	int upadteMedicine(Medicine c);
 	int deleteMedicineByName(String name);
 	void deleteallMedicine();

}
