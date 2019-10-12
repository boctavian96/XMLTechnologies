package octavian.xmltech.datasource.sax;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import octavian.xmltech.app.Config;
import octavian.xmltech.datamodel.Author;
import octavian.xmltech.datamodel.Department;
import octavian.xmltech.datamodel.Publication;
import octavian.xmltech.datamodel.builder.DepartmentBuilder;

public class ElementHandler extends DefaultHandler {
	
	private DepartmentBuilder departmentBuilder;

	private List<Author> authors;
	private List<Department> departments;
	private List<Publication> publications;
	
	private boolean aElement;
	
	private boolean dElement;
	private boolean dIdElement;
	private boolean dNameElement;
	
	private boolean pElement;
	
	public ElementHandler() {
		super();
		authors = new ArrayList<>();
		departments = new ArrayList<>();
		publications = new ArrayList<>();
		
		departmentBuilder = new DepartmentBuilder();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(Config.AUTHOR.equals(qName)) {
			aElement = true;	
			return;
		}
		if(Config.DEPARTMENT.equals(qName)) {
			dElement = true;
			return;
		}
		if(Config.PUBLICATION.equals(qName)) {
			pElement = true;
			return;
		}
		evaluateElement(qName);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) {
	      
	      if (Config.AUTHOR.equals(qName)) {
	         System.out.println("End Element :" + qName);
	         aElement = false;
	         //authors.add(authorBuilder.build());
	      }
	      
	      if (Config.DEPARTMENT.equals(qName)) {
		     System.out.println("End Element :" + qName);
		     dElement = false;
		     departments.add(departmentBuilder.build());
		  }
	      
	      if (Config.PUBLICATION.equals(qName)) {
		     System.out.println("End Element :" + qName);
		     pElement = false;
		     //publications.add(publicationBuilder.build());
		  }
	   }
	
	@Override
	public void characters(char ch[], int start, int length) {
		
		if(aElement) {
			return;
		}
		
		if(dElement) {
			if(dIdElement) {
				departmentBuilder.buildId(Integer.parseInt(new String(ch, start, length)));
				dIdElement = false;
			}
			if(dNameElement) {
				departmentBuilder.buildName(new String(ch, start, length));
				dNameElement = false;
			}
		}
		
		if(pElement) {
			return;
		}
	}
	
	private void evaluateElement(String qName) {
		if(aElement) {
			return;
		}
		
		if(dElement) {
			if("id".equalsIgnoreCase(qName)) {
				dIdElement=true;
				return;
			}
			if("name".equalsIgnoreCase(qName)) {
				dNameElement=true;
				return;
			}
		}
		
		if(pElement) {
			return;
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
