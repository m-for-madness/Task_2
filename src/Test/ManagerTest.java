package Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InvalidNameException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ClientModule.Customer;
import ClientModule.Manager;


// TODO: Auto-generated Javadoc
/**
 * The Class ManagerTest.
 */
public class ManagerTest {

	/** The set. */
	static Manager set;
	
	/** The c1. */
	static Customer c1;
	
	/** The c2. */
	static Customer c2;
	
	/** The c3. */
	static Customer c3;
	
	/**
	 * Before class.
	 * @throws ClientModule.InvalidNameException 
	 */
	@BeforeClass
	public static void beforeClass() throws ClientModule.InvalidNameException{
		set = new Manager();
		c1 = new Customer("dd", "gg", "st1", 1234);
		c2 = new Customer("ff", "hh", "st2",2345);
		c3 = new Customer("qq", "ee", "st3", 5678);
	}
	
	/**
	 * Before.
	 */
	@Before 
	public void before(){
		set.addtoSet(c1);
		set.addtoSet(c2);
		set.addtoSet(c3);	
	}
	
	/**
	 * After.
	 */
	@After 
	public void after(){
		set.getSet().clear();
	}
	
	/**
	 * Test addto set.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testAddtoSet()throws Exception{
		int n = set.getSet().size();
		set.addtoSet(new Customer("rty", "yuo", "st999", 9999));
		assertEquals(n+1, set.getSet().size());
	}
	
	/**
	 * Testparse int.
	 *
	 * @throws Exception the exception
	 */
	@Test 
	public void testparseInt()throws Exception{
		Customer c = new Customer();
		String s="12345";
		assertEquals(12345,c.parseInt(s));
	}
	
	/**
	 * Test read.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testRead()throws Exception{
		File file = new File("inputFile.txt");
		 PrintWriter out = new PrintWriter(file.getAbsoluteFile());
		set.getSet().clear();
		for (Customer c : set.getSet()) {
			assertNull(c);
		}
		c1.read("inputFile.txt", set.getSet());
		for (Customer c : set.getSet()) {
			assertNotNull(c);
		}
		out.close();
	}
	
	/**
	 * Test valid name.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testValidName()throws Exception{
		Customer c= new Customer();
		String s = "as";
		c.validName(s);
		assertEquals("as", s);
	}
	
	/**
	 * Test write.
	 *
	 * @throws Exception the exception
	 */
	@Test 
	public void testWrite() throws Exception{
		File file = new File("outputFile.txt");
		c1.write("outputFile.txt", set.getSet());
		
		assertNotNull(file);
		}
		
	/**
	 * Test add.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testAdd() throws Exception{
		Manager m = new Manager();
		m.addtoSet(new Customer("ff","nn","st12",1234));
		assertEquals(1, m.getSet().size());
	}
	
}
