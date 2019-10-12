package octavian.xmltech.datasource.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import octavian.xmltech.app.Config;
import octavian.xmltech.datamodel.Author;
import octavian.xmltech.datamodel.Department;
import octavian.xmltech.datamodel.Publication;

public class ElementHandler extends DefaultHandler {

	private List<Author> authors;
	private List<Department> departments;
	private List<Publication> publications;
	
	public ElementHandler() {
		super();
		authors = new ArrayList<>();
		departments = new ArrayList<>();
		publications = new ArrayList<>();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(Config.AUTHOR.equals(qName)) {
			
		}
		if(Config.DEPARTMENT.equals(qName)) {
			
		}
		if(Config.PUBLICATION.equals(qName)) {
			
		}
	}
	
	public List<Author> getAuthors(){
		return this.authors;
	}
	
	public List<Department> getDepartments(){
		return this.departments;
	}
	
	public List<Publication> getPublications(){
		return this.publications;
	}
		
	}
}
