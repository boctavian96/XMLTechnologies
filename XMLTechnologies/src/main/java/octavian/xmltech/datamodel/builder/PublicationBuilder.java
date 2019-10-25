package octavian.xmltech.datamodel.builder;

import octavian.xmltech.datamodel.Publication;

public class PublicationBuilder {
	private int id;
	private String type;
	private String name;
	private String year;
	private int[] authors;
	private String isbn;
	private String url;
	private int citations;
	
	public PublicationBuilder buildId(int id) {
		this.id = id;
		return this;
	}
	
	public PublicationBuilder buildType(String type) {
		this.type = type;
		return this;
	}
	
	public PublicationBuilder buildName(String name) {
		this.name = name;
		return this;
	}

	public PublicationBuilder buildYear(String year) {
		this.year = year;
		return this;
	}

	public PublicationBuilder buildAuthors(int[] authors) {
		this.authors = authors;
		return this;
	}

	public PublicationBuilder buildISBN(String isbn) {
		this.isbn = isbn;
		return this;
	}

	public PublicationBuilder buildUrl(String url) {
		this.url = url;
		return this;
	}

	public PublicationBuilder buildCitations(int citations) {
		this.citations = citations;
		return this;
	}
	
	public Publication build() {
		Publication publication = new Publication(id, type, name, year, authors, isbn, url, citations);
		flush();
		return publication;
	}
	
	public void flush() {
		id = Integer.MIN_VALUE;
		type = null;
		year = null;
		authors = null;
		isbn = null;
		url = null;
		citations = Integer.MIN_VALUE;
	}


}
