package com.edubridge.medicine.service;

import java.util.List;

import com.edubridge.medicine.dao.MedicineDaoImpl;
import com.edubridge.medicine.model.Medicine;

public class MedicineServiceImpl implements MedicineService {
      private MedicineDaoImpl dao = new MedicineDaoImpl();

	@Override
	public int addMedicine(Medicine c) {
		
		return dao.addMedicine(c);
	}

	@Override
	public List<Medicine> findMedicine() {
		
		return dao.findContacts();
	}

	@Override
	public Medicine findMedicineByName(String name) {
		
		return dao.findMedicineByName(name);
	}

	@Override
	public int upadteMedicine(Medicine c) {
		// TODO Auto-generated method stub
		return dao.upadteMedicine(c);
	}

	@Override
	public int deleteMedicineByName(String name) {
		// TODO Auto-generated method stub
		return dao.deleteMedicineByName(name);
	}

	@Override
	public void deleteallMedicine() {
		// TODO Auto-generated method stub
		dao.deleteallMedicine();
	}
      

}
