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
import octavian.xmltech.datamodel.builder.AuthorBuilder;
import octavian.xmltech.datamodel.builder.DepartmentBuilder;
import octavian.xmltech.datamodel.builder.PublicationBuilder;

public class ElementHandler extends DefaultHandler {
	
	private DepartmentBuilder departmentBuilder;
	private AuthorBuilder authorBuilder;
	private PublicationBuilder publicationBuilder;

	private List<Author> authors;
	private List<Department> departments;
	private List<Publication> publications;
	
	private boolean aElement;
	private boolean aIdElement;
	private boolean aFirstname;
	private boolean aLastname;
	private boolean aAddress;
	private boolean aMobile;
	private List<Integer> affiliationList;
	private boolean aAffiliation;
	
	private boolean dElement;
	private boolean dIdElement;
	private boolean dNameElement;
	
	private boolean pElement;
	private boolean pId;
	private boolean pType;
	private boolean pName;
	private boolean pYear;
	private List<Integer> authorsList;
	private boolean pAuthors;
	private boolean pISBN;
	private boolean pCitations;
	
	public ElementHandler() {
		super();
		authors = new ArrayList<>();
		departments = new ArrayList<>();
		publications = new ArrayList<>();
		
		affiliationList = new ArrayList<>();
		authorsList = new ArrayList<>();
		
		departmentBuilder = new DepartmentBuilder();
		authorBuilder = new AuthorBuilder();
		publicationBuilder = new PublicationBuilder();
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
	         int[] aList = affiliationList.stream().mapToInt(i -> i).toArray();
	         authorBuilder.buildAffiliations(aList);
	         affiliationList = new ArrayList<>();
	         authors.add(authorBuilder.build());
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
			if(aIdElement) {
				authorBuilder.buildId(Integer.parseInt(new String(ch, start, length)));
				aIdElement=false;
			}
			if(aFirstname) {
				authorBuilder.buildFirstName(new String(ch, start, length));
				aFirstname=false;
			}
			if(aLastname) {
				authorBuilder.buildLastName(new String(ch, start, length));
				aLastname=false;
			}
			if(aAddress) {
				authorBuilder.buildAddress(new String(ch, start, length));
				aAddress=false;
			}
			if(aMobile) {
				authorBuilder.buildMobile(new String(ch, start, length));
				aMobile=false;
			}
			if(aAffiliation) {
				affiliationList.add(Integer.parseInt(new String(ch, start, length)));
				aAffiliation=false;
			}
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
			if("id".equalsIgnoreCase(qName)) {
				aIdElement=true;
			}
			if("firstname".equalsIgnoreCase(qName)) {
				aFirstname=true;
			}
			if("lastname".equalsIgnoreCase(qName)) {
				aLastname=true;
			}
			if("address".equalsIgnoreCase(qName)) {
				aAddress=true;
			}
			if("mobile".equalsIgnoreCase(qName)) {
				aMobile=true;
			}
			if("departmentId".equalsIgnoreCase(qName)) {
				aAffiliation=true;
			}
			
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
