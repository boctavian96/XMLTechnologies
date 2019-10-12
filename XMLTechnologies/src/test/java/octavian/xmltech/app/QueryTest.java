package octavian.xmltech.app;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import octavian.xmltech.datamodel.Database;
import octavian.xmltech.datamodel.Publication;
import octavian.xmltech.datasource.DataSource;
import octavian.xmltech.datasource.dom.DomSource;
import octavian.xmltech.datasource.sax.SaxSource;

public class QueryTest {
	
	//-----------------DOM ASSETS-----------------------
	private DataSource domSource = new DomSource();
	private Database databaseDom = domSource.readSource();
	
	//-----------------SAX ASSETS-----------------------
	private DataSource saxSource = new SaxSource();
	private Database databaseSax = saxSource.readSource();
	
	@Test
	public void testDOMAutor() {		
		Query query = new Query(databaseDom);
		
		List<Publication> autor1 = query.selectForAuthors(1);
		List<Publication> autor2 = query.selectForAuthors(2);
		List<Publication> autor3 = query.selectForAuthors(3);
		List<Publication> autor4 = query.selectForAuthors(4);
		
		System.out.println();
		print(autor1);
		System.out.println();
		print(autor2);
		System.out.println();
		print(autor3);
		System.out.println();
		print(autor4);
	}

	@Test
	public void testDOMCategoriiDeLucrari() {		
		Query query = new Query(databaseDom);
		
		List<Publication> jurnale = query.selectCategory("Jurnal");
		List<Publication> conferinte = query.selectCategory("Conferinta");
		List<Publication> vc = query.selectCategory("Volum Colectiv");
		
		System.out.println("\n----------Jurnale----------\n");
		print(jurnale);
		System.out.println("\n----------Conferinte----------\n");
		print(conferinte);
		System.out.println("\n----------Volume Colective----------\n");
		print(vc);
	}
	
	@Test
	public void testDOMUniversitate() {		
		Query query = new Query(databaseDom);
		
		List<Publication> departament1 = query.selectForUniversity(1);
		List<Publication> departament2 = query.selectForUniversity(2);
		List<Publication> departament3 = query.selectForUniversity(3);
		List<Publication> departament4 = query.selectForUniversity(4);
		
		System.out.println();
		print(departament1);
		System.out.println();
		print(departament2);
		System.out.println();
		print(departament3);
		System.out.println();
		print(departament4);
	
	}
	
	@Test
	public void testSAX() {
		fail("Not yet implemented");
	}
	
	private void print(List list) {
		for(Object element : list) {
			System.out.println(element);
		}
	}

}
