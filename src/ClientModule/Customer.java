package ClientModule;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
	private String first_name;
	private String surname;
	private String address;
	private int unc;// unique numeric code


	private int sum;// total sum of order
	
	/**
	 * Instantiates a new customer.
	 */
	public Customer() {}
	
	/**
	 * Instantiates a new customer.
	 */
	public Customer(String first_name, String surname,String address, int sum) throws InvalidNameException {
		// function which check if string contain only letters
		validName(first_name);
		this.first_name = first_name;
		validName(surname);
		this.surname = surname;
		this.address = address;
		this.sum = sum;
		unc = hashCode();// use Object.hashcode()
	}

	
	public String toString() {
		return "Name of customer: "+first_name +" "+ surname+ "\n"+"address: "+ address+ "\n" + "Total order of this customer: "+ sum+"\n"+ "Unique code: "+unc+ "\n";
	}
	
	/**
	 * Write.
	 *
	 * @param fileName the file name
	 * @param set the set
	 */
	//method which write the info into outputFile
	public static void write(String fileName,Set<Customer> set) {
	
	    File file = new File(fileName);
	 
	    try {
	        if(!file.exists()){
	            file.createNewFile();
	        }
	 
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	 
	        try {
	        	for (Customer c : set) {
	    			out.println(c);
	    		}
	        } finally {
	        	// this block of code will close the file in any case
	           out.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	    
	}
	
	
	// function which checks if file exists
	private static void exists(String fileName) throws FileNotFoundException {
	    File file = new File(fileName);
	    if (!file.exists()){
	        throw new FileNotFoundException(file.getName());
	    }
	}
	

	//function which read and works out some info from input file
	public void read(String fileName, Set <Customer> set) throws FileNotFoundException, InvalidNameException {
	   
		File file = new File(fileName);
	    exists(fileName);
	 
	    try {
	        BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
	        try {
	            String s;
	            int i=0;	            
	            // read one string per iteration and define it to some field of object
	            while ((s = in.readLine()) != null) {
	            	if (i==0){
	            		validName(s);
	            		first_name=s;            		
	            	}
	            	if (i==1){
	            		validName(s);
	            		surname= s;
	            	}            		
	            	if (i==2)
	            	{
	            		
	            		address=s;
	            	}	            		
	            	if(i==3)
	            	{
	            		sum=parseInt(s);
	            	}           		
	                ++i;
	                if (i==4)
	                {
	                	// add new object to set of Customer
	                	set.add(new Customer(first_name, surname, address, sum));
	                	i=0;
	                }
	            }
	        } finally {
	            in.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	    
	 
	}
	
	/**
	 * Input_keyboard.
	 *
	 * @return the customer
	 * @throws InvalidNameException the invalid name exception
	 */
	public Customer input_keyboard() throws InvalidNameException{
		System.out.println("Input first name and surname of the customer.");
		Scanner sc = new Scanner(System.in);
		first_name=sc.next();
		validName(first_name);
		surname=sc.next();
		validName(surname);
		System.out.println("Input address of the customer");
		address = sc.next();
		System.out.println("Input total value");
		sum=parseInt(sc.next());
		return new Customer(first_name, surname,address,sum);
	}
	
	/**
	 * Output.
	 *
	 * @param set the set
	 */
	// output all customers
	public static void output(Set<Customer> set){
		if (set.isEmpty()){
			System.out.println("Set is empty");
		}
		else
		for (Customer c : set) {
			System.out.println(c);
		}
	}
	
	/**
	 * Output_special.
	 *
	 * @param set the set
	 */
	// output all customers whom sum is even or greater than a specific value
	public static void output_special(Set<Customer> set){
		System.out.print("Input specific value :");
		Scanner sc = new Scanner(System.in);
		int k=sc.nextInt();
		int m=0;
		for (Customer c : set) {
			
			if (c.sum>=k)
			{
				++m;
			System.out.println(c);
			}
			
		}
		if (m==0){
			System.out.println("There are no customers with even or greater total than entered value");
		}
	}
	
	/**
	 * Parses the int.
	 *
	 * @param s the s
	 * @return the int
	 * @throws NumberFormatException the number format exception
	 */
	// check if string contains only figures , if it is true then transform string into number
	// in another case throw invalid number exception
	public int parseInt(String s)
			throws NumberFormatException
		{
		try {
			return  Integer.parseInt(s,10);
		}
		catch (NumberFormatException e){
			System.out.println(e.toString());
			System.out.println("You have to input only figures");
			//exit the program
			System.exit(0);
			return 0;
		}
		}
	
	/**
	 * Valid name.
	 *
	 * @param myid the myid
	 * @throws InvalidNameException the invalid name exception
	 */
	// in this function we check if string contains only letters, if there are figures , we throw the exception
	public void validName(String myid) throws InvalidNameException{
		Pattern p=Pattern.compile("[0-9]");
		Matcher m=p.matcher(myid);
		try{
			if(m.find())
				throw new InvalidNameException();
			
		}catch(InvalidNameException e){
			System.out.println(e.toString());
			System.exit(0);
		}
	}

}
//define the exception which explain more clearly about nature of the exception
 
