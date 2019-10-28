package octavian.xmltech.datasource.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.helpers.DefaultHandler;

import octavian.xmltech.datamodel.builder.AuthorBuilder;
import octavian.xmltech.datamodel.builder.DepartmentBuilder;
import octavian.xmltech.datamodel.builder.PublicationBuilder;

public class BasicHandler extends DefaultHandler{
	
	protected DepartmentBuilder departmentBuilder;
	protected AuthorBuilder authorBuilder;
	protected PublicationBuilder publicationBuilder;

	protected boolean aElement;
	protected boolean aIdElement;
	protected boolean aFirstname;
	protected boolean aLastname;
	protected boolean aAddress;
	protected boolean aMobile;
	protected List<Integer> affiliationList;
	protected boolean aAffiliation;
	
	protected boolean dElement;
	protected boolean dIdElement;
	protected boolean dNameElement;
	
	protected boolean pElement;
	protected boolean pIdElement;
	protected boolean pTypeElement;
	protected boolean pNameElement;
	protected boolean pYearElement;
	protected List<Integer> authorsList;
	protected boolean pAuthorsElement;
	protected boolean pISBNElement;
	protected boolean pUrlElement;
	protected boolean pCitationsElement;
	
	public BasicHandler() {
		departmentBuilder = new DepartmentBuilder();
		authorBuilder = new AuthorBuilder();
		publicationBuilder = new PublicationBuilder();
		affiliationList = new ArrayList<>();
		authorsList = new ArrayList<>();
	}
}
