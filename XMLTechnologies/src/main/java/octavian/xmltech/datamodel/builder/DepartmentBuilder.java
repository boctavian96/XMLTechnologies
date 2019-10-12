package octavian.xmltech.datamodel.builder;

import octavian.xmltech.datamodel.Department;

public class DepartmentBuilder {
	int id;
	String name;
	
	public DepartmentBuilder() {
		super();
	}
	
	public DepartmentBuilder buildId(int id) {
		this.id=id;
		return this;
	}
	
	public DepartmentBuilder buildName(String name) {
		this.name = name;
		return this;
	}
	
	public Department build() {
		Department dep = new Department(id, name);
		flush();
		
		return dep;
	}
	
	public void flush() {
		this.id = Integer.MIN_VALUE;
		this.name = null;
	}
}
