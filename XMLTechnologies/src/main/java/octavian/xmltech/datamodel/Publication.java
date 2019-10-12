package octavian.xmltech.datamodel;

import java.util.Arrays;

public class Publication {
	private int id;
	private String type;
	private String name;
	private String year;
	private int[] authors;
	private String ISBN;
	private String URL;
	private int citations;
	
	public Publication(int id, String type, String name, String year, int[] authors, String iSBN, String uRL, int citations) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.year = year;
		this.authors = authors;
		ISBN = iSBN;
		URL = uRL;
		this.citations = citations;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int[] getAuthors() {
		return authors;
	}

	public void setAuthors(int[] authors) {
		this.authors = authors;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public int getCitations() {
		return citations;
	}

	public void setCitations(int citations) {
		this.citations = citations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
		result = prime * result + ((URL == null) ? 0 : URL.hashCode());
		result = prime * result + Arrays.hashCode(authors);
		result = prime * result + citations;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		Publication other = (Publication) obj;
		if (ISBN == null) {
			if (other.ISBN != null)
				return false;
		} else if (!ISBN.equals(other.ISBN))
			return false;
		if (URL == null) {
			if (other.URL != null)
				return false;
		} else if (!URL.equals(other.URL))
			return false;
		if (!Arrays.equals(authors, other.authors))
			return false;
		if (citations != other.citations)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Publication [id=" + id + ", type=" + type + ", name=" + name + ", year=" + year + ", authors="
				+ Arrays.toString(authors) + ", ISBN=" + ISBN + ", URL=" + URL + ", citations=" + citations + "]";
	}
	
	

}