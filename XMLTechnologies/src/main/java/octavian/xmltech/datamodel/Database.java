package octavian.xmltech.datamodel;

import java.util.List;

public class Database {
	private List<Author> authors;
	private List<Department> departments;
	private List<Publication> publications;
	
	public Database(List<Author> authors, List<Department> departments, List<Publication> pub) {
		super();
		this.authors = authors;
		this.departments = departments;
		this.publications = pub;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public List<Publication> getPublications() {
		return publications;
	}
	
}
