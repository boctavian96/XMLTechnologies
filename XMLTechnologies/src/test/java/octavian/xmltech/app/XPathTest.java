package octavian.xmltech.app;

import static org.junit.Assert.*;

/* 
 #Select all the authors.
child::database/authors

#Select all departments.
child::database/departments

#Select all the publications.
child::database/publications

#Select all the publications that have citations more than 10000.
child::database/publications/publication[citations>10000]

#Select all the publications that are journals.
child::database/publications/publication[type="Jurnal"]

#Multiple predicates.
child::database/publications/publication[type="Jurnal" and id=4]

#Articles by Davinci
child::database/publications/publication[authorId=3]

#Select a specific author
child::database/authors/author[firstname="Leonardo" and lastname="Davinci"]

#Multiple XPaths in one Query.
child::database/publications/publication[citations>10000]/name | /database/publications/publication[citations>10000]/authors/authorId
 
#Davinci writings
child::database/authors/author[lastname="Davinci"] | /database/publication/publication/authors[authorId=3]

 */

import org.junit.Test;

import octavian.xmltech.datasource.dom.XPathDomSource;

public class XPathTest {

	private XPathDomSource xPathSource = new XPathDomSource();

	@Test
	public void testBasicXPath() {

		System.out.println("Authors");
		String authors = xPathSource.readSource("/database/authors");
		System.out.println(authors);

		System.out.println("Departments");
		String departments = xPathSource.readSource("/database/departments");
		System.out.println(departments);

		System.out.println("Publications");
		String publications = xPathSource.readSource("/database/publications");
		System.out.println(publications);

		assertNotNull(authors);
		assertNotNull(departments);
		assertNotNull(publications);
	}

	@Test
	public void testIntPredicate() {
		System.out.println("Publications that have more than 10000 citations");
		String tenTousand = xPathSource.readSource("database/publications/publication[citations>10000]");
		System.out.println(tenTousand);
	}
	
	@Test
	public void testStringPredicate() {
		System.out.println("Only Journals");
		String stringPredicate = xPathSource.readSource("database/publications/publication[type=\"Jurnal\"]");
		System.out.println(stringPredicate);
	}
	
	@Test
	public void testMultiplePredicates() {
		System.out.println("Multiple predicates");
		String twoPredicates = xPathSource.readSource("database/publications/publication[type=\"Jurnal\" and id=4]");
		System.out.println(twoPredicates);
	}
	
	@Test
	public void testPredicates() {
		System.out.println("Search for a specific author");
		String twoPredicates = xPathSource.readSource("database/publications/publication[/authorId=3]");
		System.out.println(twoPredicates);
	}
	
	@Test
	public void testSpecificPredicates() {
		System.out.println("Journals that have an specific ID");
		String twoPredicates = xPathSource.readSource("database/authors/author[firstname=\"Leonardo\" and lastname=\"Davinci\"]");
		System.out.println(twoPredicates);
	}
	
	@Test
	public void testTwoQueries() {
		System.out.println("Great Publications");
		String twoPredicates = xPathSource.readSource("database/publications/publication[citations>10000]/name | /database/publications/publication[citations>10000]/authors/authorId");
		System.out.println(twoPredicates);
	}

	@Test
	//ERROR :( 
	public void testDaVinci() {
		System.out.println("DaVinci's writings");
		String twoPredicates = xPathSource.readSource("database/authors/author[lastname=\"Davinci\"] | /database/publication/publication/authors[authorId=3]");
		System.out.println(twoPredicates);
	}
}
