package octavian.xmltech.datamodel;

import java.util.Arrays;

public class Author{

    private int id;
    private String fName;
    private String lName;
    private String address;
    private String mobile;
    private int[] affiliations;
    
    public Author() {
    	super();
    }
    
    public Author(int id, String fName, String lName, String address, String mobile, int[] affiliations){
        super();
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.mobile = mobile;
        this.affiliations = affiliations;
    }
    
    public boolean hasAffiliation(int department) {
    	for(int affiliation : affiliations) {
    		if(affiliation == department) {
    			return true;
    		}
    	}
    	return false;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int[] getAffiliations() {
		return affiliations;
	}

	public void setAffiliations(int[] affiliations) {
		this.affiliations = affiliations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + Arrays.hashCode(affiliations);
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
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
		Author other = (Author) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (!Arrays.equals(affiliations, other.affiliations))
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (id != other.id)
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", fName=" + fName + ", lName=" + lName + ", address=" + address + ", mobile="
				+ mobile + ", affiliations=" + Arrays.toString(affiliations) + "]";
	}

}