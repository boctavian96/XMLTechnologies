package octavian.xmltech.app;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import octavian.xmltech.datamodel.Author;
import octavian.xmltech.datamodel.Database;
import octavian.xmltech.datamodel.Department;
import octavian.xmltech.datamodel.Publication;
import octavian.xmltech.datasource.DataSource;
import octavian.xmltech.datasource.dom.DomSource;

public class DOMTest {

	@Test
	public void test() {
		DataSource dataSource = new DomSource();
		Database db = dataSource.readSource();

		assertNotNull(db);

		
		List<Author> authors = db.getAuthors();
		List<Department> departments = db.getDepartments();
		List<Publication> publications = db.getPublications();
		
		assertNotNull(authors);
		assertNotNull(departments);
		assertNotNull(publications);
		
		System.out.println("Authors");
		for(Author a : authors) {
			System.out.println(a);
		}
		
		System.out.println("Departments");
		for(Department d : departments) {
			System.out.println(d);
		}
		
		System.out.println("Publications");
		for(Publication p : publications) {
			System.out.println(p);
		}
		
		
	}

}
