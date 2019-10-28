package octavian.xmltech.datasource.sax;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import octavian.xmltech.app.Config;
import octavian.xmltech.datamodel.Author;
import octavian.xmltech.datamodel.Department;
import octavian.xmltech.datamodel.Publication;

public class SimpleQueryHandler extends BasicHandler {

	private String elementType;
	private int id;

	private Author author;
	private Department department;
	private Publication publication;

	private boolean searchedObject;
	private boolean done;

	public SimpleQueryHandler(String elementType, int id) {
		super();
		this.elementType = elementType;
		this.id = id;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (Config.AUTHOR.equals(qName) && Config.AUTHOR.equalsIgnoreCase(elementType)) {
			aElement = true;
			return;
		}
		if (Config.DEPARTMENT.equals(qName) && Config.DEPARTMENT.equalsIgnoreCase(elementType)) {
			dElement = true;
			return;
		}
		if (Config.PUBLICATION.equals(qName) && Config.PUBLICATION.equalsIgnoreCase(elementType)) {
			pElement = true;
			return;
		}
		evaluateElement(qName);
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException {
		if (aElement) {
			if (aIdElement && !done) {
				int localId = Integer.parseInt(new String(ch, start, length));
				if (id == localId) {
					searchedObject = true;
					authorBuilder.buildId(localId);
					aIdElement = false;
				}

			}
			if (aFirstname && searchedObject) {
				authorBuilder.buildFirstName(new String(ch, start, length));
				aFirstname = false;
			}
			if (aLastname && searchedObject) {
				authorBuilder.buildLastName(new String(ch, start, length));
				aLastname = false;
			}
			if (aAddress && searchedObject) {
				authorBuilder.buildAddress(new String(ch, start, length));
				aAddress = false;
			}
			if (aMobile && searchedObject) {
				authorBuilder.buildMobile(new String(ch, start, length));
				aMobile = false;
			}
			if (aAffiliation && searchedObject) {
				affiliationList.add(Integer.parseInt(new String(ch, start, length)));
				aAffiliation = false;
			}
		}

		if (dElement) {
			if (dIdElement && !done) {
				int localId = Integer.parseInt(new String(ch, start, length));
				if (id == localId) {
					searchedObject = true;
					departmentBuilder.buildId(localId);
					dIdElement = false;
				}

			}
			if (dNameElement && searchedObject) {
				departmentBuilder.buildName(new String(ch, start, length));
				dNameElement = false;
			}
		}

		if (pElement) {
			if (pIdElement) {
				pIdElement = false;

				int localId = Integer.parseInt(new String(ch, start, length));
				if (id == localId) {
					searchedObject = true;
					publicationBuilder.buildId(localId);
					pIdElement = false;
				}
			}
			if (pTypeElement && searchedObject) {
				publicationBuilder.buildType(new String(ch, start, length));
				pTypeElement = false;
			}
			if (pNameElement && searchedObject) {
				publicationBuilder.buildName(new String(ch, start, length));
				pNameElement = false;
			}
			if (pYearElement && searchedObject) {
				publicationBuilder.buildYear(new String(ch, start, length));
				pYearElement = false;
			}
			if (pAuthorsElement && searchedObject) {
				authorsList.add(Integer.parseInt(new String(ch, start, length)));
				pAuthorsElement = false;
			}
			if (pISBNElement && searchedObject) {
				publicationBuilder.buildISBN(new String(ch, start, length));
				pISBNElement = false;
			}
			if (pUrlElement && searchedObject) {
				publicationBuilder.buildUrl(new String(ch, start, length));
				pUrlElement = false;
			}
			if (pCitationsElement && searchedObject) {
				publicationBuilder.buildCitations(Integer.parseInt(new String(ch, start, length)));
				pCitationsElement = false;
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		if (Config.AUTHOR.equals(qName) && Config.AUTHOR.equalsIgnoreCase(elementType) && !done) {
			System.out.println("End Element :" + qName);
			aElement = false;
			int[] aList = affiliationList.stream().mapToInt(i -> i).toArray();
			authorBuilder.buildAffiliations(aList);
			affiliationList = new ArrayList<>();

			// TODO: change this
			System.out.println(authorBuilder.build());
			searchedObject = false;
			done = true;
		}

		if (Config.DEPARTMENT.equals(qName) && Config.DEPARTMENT.equalsIgnoreCase(elementType) && !done) {
			System.out.println("End Element :" + qName);
			dElement = false;
			System.out.println(departmentBuilder.build());
			/// departments.add(departmentBuilder.build());
			searchedObject = false;
			done = true;
		}

		if (Config.PUBLICATION.equals(qName) && Config.PUBLICATION.equalsIgnoreCase(elementType) && !done) {
			System.out.println("End Element :" + qName);
			pElement = false;
			int[] aList = authorsList.stream().mapToInt(i -> i).toArray();
			authorsList = new ArrayList<>();
			publicationBuilder.buildAuthors(aList);
			System.out.println(publicationBuilder.build());
			/// publications.add(publicationBuilder.build());
			searchedObject = false;
			done = true;
		}
	}

	protected void evaluateElement(String qName) {
		if (aElement) {
			if ("id".equalsIgnoreCase(qName)) {
				aIdElement = true;
				return;
			}
			if ("firstname".equalsIgnoreCase(qName)) {
				aFirstname = true;
				return;
			}
			if ("lastname".equalsIgnoreCase(qName)) {
				aLastname = true;
				return;
			}
			if ("address".equalsIgnoreCase(qName)) {
				aAddress = true;
				return;
			}
			if ("mobile".equalsIgnoreCase(qName)) {
				aMobile = true;
				return;
			}
			if ("departmentId".equalsIgnoreCase(qName)) {
				aAffiliation = true;
				return;
			}

		}

		if (dElement) {
			if ("id".equalsIgnoreCase(qName)) {
				dIdElement = true;
				return;
			}
			if ("name".equalsIgnoreCase(qName)) {
				dNameElement = true;
				return;
			}
		}

		if (pElement) {
			if ("id".equalsIgnoreCase(qName)) {
				pIdElement = true;
			}
			if ("type".equalsIgnoreCase(qName)) {
				pTypeElement = true;
			}
			if ("name".equalsIgnoreCase(qName)) {
				pNameElement = true;
			}
			if ("year".equalsIgnoreCase(qName)) {
				pYearElement = true;
			}
			if ("authorId".equalsIgnoreCase(qName)) {
				pAuthorsElement = true;
			}
			if ("ISBN".equalsIgnoreCase(qName)) {
				pISBNElement = true;
			}
			if ("URL".equalsIgnoreCase(qName)) {
				pUrlElement = true;
			}
			if ("citations".equalsIgnoreCase(qName)) {
				pCitationsElement = true;
			}
		}

	}

}
