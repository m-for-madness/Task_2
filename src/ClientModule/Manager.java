package ClientModule;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


// TODO: Auto-generated Javadoc
/**
 * The Class Manager.
 */
public class Manager {
		
		/** The set. */
		Set<Customer> set=new HashSet<>();

		/**
		 * Menu.
		 *
		 * @throws FileNotFoundException the file not found exception
		 * @throws InvalidNameException the invalid name exception
		 */
		// the main function 
		public void menu() throws FileNotFoundException, InvalidNameException{
		Customer c= new Customer();
		//fill set by some predefined customers
		addtoSet(new Customer("fn", "sr", "some add 1", 10));
		addtoSet(new Customer("fna", "sr", "some add 2", 100));
		addtoSet(new Customer("fnam", "sr", "some add 3", 1000));
		addtoSet(new Customer("fname", "sr", "some add 4", 10000));
		int choice=1;
		do{
		System.out.println("Input 1, if you want to enter the customers from file");
		System.out.println("Input 2, if you want to enter the customers from keyboard");
		System.out.println("Input 3, if you want to display the customers with specific value");
		Scanner sc = new Scanner(System.in);
		int g=c.parseInt(sc.next());
		if (g==1){
		// read customers from input file , where they are defined
		c.read("inputFile.txt",set);
		c.output(set);
		}
		if (g==2){
			System.out.println("How much customers do you want to input? ");
			int k= c.parseInt(sc.next());
			for (int i = 0; i < k; i++) {
				addtoSet(c.input_keyboard());
			}
			// display all customers in the set into the console
			c.output(set);
		}
		if (g==3){
			c.output_special(set);
		}
			System.out.println("Do you want to continue? Yes - 1 / No - 0");
			choice=c.parseInt(sc.next());
		}while(choice==1);
		
		
		// display all customers in the output file
		c.write("outputFile.txt",set);
		
	}
		
		/**
		 * Addto set.
		 *
		 * @param c the c
		 */
		public void addtoSet(Customer c){
			set.add(c);
		}
		
		/**
		 * Gets the sets the.
		 *
		 * @return the sets the
		 */
		public Set<Customer> getSet() {
			return set;
		}
		
}

