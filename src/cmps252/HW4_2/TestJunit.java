package cmps252.HW4_2;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class TestJunit {
	
   
   FileParser messageUtil = new FileParser();
   
   ArrayList<Customer> customers =  messageUtil.getCustomers("C:\\temp\\hw4.2\\cmps252_hw4.2\\5000.csv");
   String[] expectedArray = {"4891 Pacific Hwy","San Diego","San Diego","CA","92110","858-294-0682","858-294-1695","portia@mcfann.com","http://www.portiamcfann.com"};
   String[] resultArray =  {customers.get(1).getAddress(),customers.get(1).getCity(),customers.get(1).getCounty(),customers.get(1).getState(),customers.get(1).getZIP(),customers.get(1).getPhone(),customers.get(1).getFax(),customers.get(1).getEmail(),customers.get(1).getWeb(),};
   @Test
   public void testPrintMessage() {
	   //get(1) because the first line (0) is the titles of the fields
	   String firstName = customers.get(1).getFirstName();
	   String lastName = customers.get(1).getLastName();
	   String company = customers.get(1).getCompany();
	   
	   //Step 3
	   //1 FirName
       assertEquals("Portia", firstName);
       //2 LastName
       assertEquals("Mcfann", lastName);
       //3 Company
       assertEquals("Beachcomber Realty", company);
       //4 Cases 4 – 12 together in an array
       assertArrayEquals(expectedArray, resultArray);
   }
}