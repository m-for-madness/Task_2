package ClientModule;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;


// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InvalidNameException the invalid name exception
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, InvalidNameException {
		Manager m = new Manager();
		m.menu();
	}
}
