package cmps252.HW4_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//Step 2
public class FileParser {
	
	String file;
	static ArrayList<Customer> customers;
	
//	public FileParser(String file) {
//		this.file = file;
//	}
	
	public static ArrayList<Customer> getCustomers(String file){
		customers = new ArrayList<>();
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			line = br.readLine();
			while(line != null){
				String[] fields = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				for(int i=0; i<12; i++) {
					//remove the "" from each field to test them correctly in JUnit assert
					fields[i] = fields[i].replace("\"", "");
				}
				//create new customer for each line and add it to the list
				Customer customer = new Customer(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], fields[7], fields[8], fields[9], fields[10], fields[11]);
				customers.add(customer);
				//read new line
				line = br.readLine();
			}
		}catch(FileNotFoundException e){
		    System.out.println("File does not exist");
		}catch (IOException e) {
			e.printStackTrace();
		}
		return customers;
	}
}