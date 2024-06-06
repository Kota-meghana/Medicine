package com.edubridge.medicine.main;

import java.util.List;
import java.util.Scanner;

import com.edubridge.medicine.model.Medicine;
import com.edubridge.medicine.service.MedicineServiceImpl;

public class MedicineMainApp {
     public static void main(String[] args) {
		MedicineServiceImpl service = new MedicineServiceImpl();
		Medicine c = null;
		Scanner in = new Scanner(System.in);
		int option;
		do {
			System.out.println("Welcome to Medicine App");
			System.out.println("***********************");
			System.out.println("1. Add Medicine");
			System.out.println("2. View Medicine");
			System.out.println("3. Search Medicine");
		    System.out.println("4. Update Medicine");
		    System.out.println("5. Delete Medicine");
		    System.out.println("6. Delete All Medicine");
		    System.out.println("0. Exit");
		    option = in.nextInt();
		    
		    switch (option) {
		    case 1:
		    	System.out.println("ADD NEW MEDICINE");
		    	System.out.println("---------------");
		    	System.out.println("please enter name: ");
		    	String name = in.next();
		    	System.out.println("Please enter manufacture name: ");
		    	String manufactutre_name = in.next();
		    	System.out.println("Please enter price: ");
		    	int price = in.nextInt();
		    	System.out.println("Please enter expiry date: ");
		    	String expiry_date = in.next();
		    	
		    	c = new Medicine();
		    	c.setMedicine_name(name);
		    	c.setManufacture_name(manufactutre_name);
		    	c.setMedicine_price(price);
		    	c.setExpiry_date(expiry_date);
		    	
		    	int status = service.addMedicine(c);
		    	if(status == 1) {
		    		System.out.println("New Medicine is added!!!");
		    	}else {
		    		System.out.println("Something went wrong!!!");
		    	}
		    	break;
		    	
		    case 2:
		    	System.out.println("View All Medicines");
		    	List<Medicine> medicines = service.findMedicine();
		    	System.out.println("NAME\tMANUFACTURE NAME\tPRICE\t EXPIRY DATE");
		    	System.out.println("------\t------\t------\t------\t");
		    	for(Medicine medicine : medicines) {
		    		System.out.println(medicine.getMedicine_name()+"\t"+medicine.getManufacture_name()+"\t"+medicine.getMedicine_price()+"\t"+medicine.getExpiry_date());
		    		}
		    	break;
		    case 3:
		    	System.out.println("search all medicines");
		    	System.out.println("Please enter medicine name: ");
				String searchName = in.next();
				Medicine searchMedicine = service.findMedicineByName(searchName);
				if(searchMedicine != null) {
					System.out.println("Id: "+searchMedicine.getMedicine_id());
					System.out.println("Name: "+searchMedicine.getMedicine_name());
					System.out.println("Manufacture name: "+searchMedicine.getManufacture_name());
					System.out.println("Price: "+searchMedicine.getMedicine_price());
					System.out.println("Expiry Date: "+searchMedicine.getExpiry_date());
					
				}else {
					System.out.println("no medicine found!");
				}
				break;

		    case 4:
		    	System.out.println("Update Medicines");
		    	System.out.println("Please enter medicine name: ");
				searchName = in.next();
				searchMedicine = service.findMedicineByName(searchName);
				
				if(searchMedicine != null) {
					//displaying existing contact details
					System.out.println("Id: "+searchMedicine.getMedicine_id());
					System.out.println("Name: "+searchMedicine.getMedicine_name());
					System.out.println("Manufacture name: "+searchMedicine.getManufacture_name());
					System.out.println("Price: "+searchMedicine.getMedicine_price());
					System.out.println("Expiry Date: "+searchMedicine.getExpiry_date());
					
					//Reading contact update info
					System.out.println("please enter updated name: ");
				     name = in.next();
					System.out.println("Please enter updated manufacture_name: ");
				     manufactutre_name = in.next();
					System.out.println("Please enter updated price: ");
					  price = in.nextInt();
					  System.out.println("Please enter expiry date: ");
					  expiry_date = in.next();
					  Medicine updateMedicine = new Medicine();
					  updateMedicine.setMedicine_name(name);
					  updateMedicine.setManufacture_name(manufactutre_name);
					  updateMedicine.setMedicine_price(price);
					  updateMedicine.setExpiry_date(expiry_date);
		             
					  updateMedicine.setMedicine_id(searchMedicine.getMedicine_id());
		
					  int updateStatus = service.upadteMedicine(updateMedicine);
					  if(updateStatus == 1) {
						  System.out.println("Medicine Updated Successfully!");
					  }else {
						  System.out.println("Something is wrong!");
					  }
				}
				else {
					System.out.println("No medicine found with name");
				}

		    	break;
		    case 5:
		    	System.out.println("Delete Medicines");
		    	System.out.println("Please enter medicine name: ");
				searchName = in.next();
				
				searchMedicine = service.findMedicineByName(searchName);
				if(searchMedicine != null) {
					int deleteStatus = service.deleteMedicineByName(searchName);
					if (deleteStatus == 1)
						System.out.println("Medicine Deleted Successfully");
					else
						System.out.println("Something is wrong");
				}else {
					System.out.println("No medicine found!");
				}

		    	break;
		    case 6:
		    	System.out.println("Delete All Medicines");
		    	System.out.println("Are you sure delete all medicines?[Y/N]");
				String deleteConfirmStatus = in.next();
                if(deleteConfirmStatus.equalsIgnoreCase("Y")) {
					service.deleteallMedicine();
					System.out.println("All Medicines Deleted!");
				}


		    	break;
		    case 0:
		    	System.out.println("Bye!!!");
		    	System.exit(0);
		    	break;
		    	
		    	default:
		    		System.out.println("Invalid option!!!");
		    	    break;
		    }    
		}while(option != 0);

     }
}
