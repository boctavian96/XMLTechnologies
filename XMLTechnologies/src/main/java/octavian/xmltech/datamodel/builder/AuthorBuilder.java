package octavian.xmltech.datamodel.builder;

import octavian.xmltech.datamodel.Author;

public class AuthorBuilder {
	int id;
	String firstName;
	String lastName;
	String mobile;
	String address;
	int[] affiliations;
	
	
	public AuthorBuilder buildId(int id) {
		this.id=id;
		return this;
	}
	
	public AuthorBuilder buildFirstName(String firstName) {
		this.firstName=firstName;
		return this;
	}
	
	public AuthorBuilder buildLastName(String lastName) {
		this.lastName=lastName;
		return this;
	}
	
	public AuthorBuilder buildMobile(String mobile) {
		this.mobile=mobile;
		return this;
	}
	
	public AuthorBuilder buildAddress(String address) {
		this.address=address;
		return this;
	}
	
	public AuthorBuilder buildAffiliations(int[] affiliations) {
		this.affiliations=affiliations;
		return this;
	}
	
	public Author build() {
		Author author = new Author(id, firstName, lastName, address, mobile, affiliations);
		flush();
		return author;
	}
	
	public void flush() {
		id = Integer.MIN_VALUE;
		firstName = null;
		lastName = null;
		address = null;
		mobile = null;
		affiliations = null;
	}
}
