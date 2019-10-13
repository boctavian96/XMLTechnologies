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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((departments == null) ? 0 : departments.hashCode());
		result = prime * result + ((publications == null) ? 0 : publications.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Database other = (Database) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (departments == null) {
			if (other.departments != null)
				return false;
		} else if (!departments.equals(other.departments))
			return false;
		if (publications == null) {
			if (other.publications != null)
				return false;
		} else if (!publications.equals(other.publications))
			return false;
		return true;
	}
	
}
