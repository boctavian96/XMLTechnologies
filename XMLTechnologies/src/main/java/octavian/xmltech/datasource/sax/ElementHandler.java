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
	private boolean pIdElement;
	private boolean pTypeElement;
	private boolean pNameElement;
	private boolean pYearElement;
	private List<Integer> authorsList;
	private boolean pAuthorsElement;
	private boolean pISBNElement;
	private boolean pUrlElement;
	private boolean pCitationsElement;
	
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
		     int[] aList = authorsList.stream().mapToInt(i -> i).toArray();
		     authorsList = new ArrayList<>();
		     publicationBuilder.buildAuthors(aList);
		     publications.add(publicationBuilder.build());
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
			if(pIdElement) {
				publicationBuilder.buildId(Integer.parseInt(new String(ch, start, length)));
				pIdElement = false;
			}
			if(pTypeElement) {
				publicationBuilder.buildType(new String(ch, start, length));
				pTypeElement = false;
			}
			if(pNameElement) {
				publicationBuilder.buildName(new String(ch, start, length));
				pNameElement = false;
			}
			if(pYearElement) {
				publicationBuilder.buildYear(new String(ch, start, length));
				pYearElement = false;
			}
			if(pAuthorsElement) {
				authorsList.add(Integer.parseInt(new String(ch, start, length)));
				pAuthorsElement = false;
			}
			if(pISBNElement) {
				publicationBuilder.buildISBN(new String(ch, start, length));
				pISBNElement = false;
			}
			if(pUrlElement) {
				publicationBuilder.buildUrl(new String(ch, start, length));
				pUrlElement = false;
			}
			if(pCitationsElement) {
				publicationBuilder.buildCitations(Integer.parseInt(new String(ch, start, length)));
				pCitationsElement = false;
			}
		}
	}
	
	private void evaluateElement(String qName) {
		if(aElement) {
			if("id".equalsIgnoreCase(qName)) {
				aIdElement=true;
				return;
			}
			if("firstname".equalsIgnoreCase(qName)) {
				aFirstname=true;
				return;
			}
			if("lastname".equalsIgnoreCase(qName)) {
				aLastname=true;
				return;
			}
			if("address".equalsIgnoreCase(qName)) {
				aAddress=true;
				return;
			}
			if("mobile".equalsIgnoreCase(qName)) {
				aMobile=true;
				return;
			}
			if("departmentId".equalsIgnoreCase(qName)) {
				aAffiliation=true;
				return;
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
			if("id".equalsIgnoreCase(qName)) {
				pIdElement=true;
			}
			if("type".equalsIgnoreCase(qName)) {
				pTypeElement=true;
			}
			if("name".equalsIgnoreCase(qName)) {
				pNameElement=true;
			}
			if("year".equalsIgnoreCase(qName)) {
				pYearElement=true;
			}
			if("authorId".equalsIgnoreCase(qName)) {
				pAuthorsElement=true;
			}
			if("ISBN".equalsIgnoreCase(qName)) {
				pISBNElement=true;
			}
			if("URL".equalsIgnoreCase(qName)) {
				pUrlElement=true;
			}
			if("citations".equalsIgnoreCase(qName)) {
				pCitationsElement=true;
			}
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
