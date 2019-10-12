package octavian.xmltech.datasource.dom;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import octavian.xmltech.app.Config;
import octavian.xmltech.datamodel.Author;
import octavian.xmltech.datamodel.Database;
import octavian.xmltech.datamodel.Department;
import octavian.xmltech.datamodel.Publication;
import octavian.xmltech.datasource.DataSource;

public class DomSource implements DataSource {

	@Override
	public Database readSource() {
		
		File xmlDatabase = new File(Config.DATABASE_FILE);
		SAXReader reader = new SAXReader();
		Document document = null;
		
		try {
			document = reader.read(xmlDatabase);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Element root = document.getRootElement();
		
		List<Node> nodesAuthors = document.selectNodes("/database/authors");
		List<Node> nodesDepartments = document.selectNodes("/database/departments");
		List<Node> nodesPublications = document.selectNodes("/database/publications");
		
		return new Database(readAuthors(nodesAuthors), readDepartments(nodesDepartments), readPublications(nodesPublications));
	}
	
	public List<Author> readAuthors(List<Node> nodes){
		List<Author> authors = new ArrayList<>();
		for (Node node : nodes) {
			int id = Integer.parseInt(node.selectSingleNode("id").getText());
			String fName = node.selectSingleNode("firstname").getText();
			String lName = node.selectSingleNode("lastname").getText();
			String address = node.selectSingleNode("address").getText();
			String mobile = node.selectSingleNode("mobile").getText();
			
			List<Node> dNodes = node.selectNodes("departments");
			int[] affiliations = new int[dNodes.size()];
			for(int i=0; i<affiliations.length; i++) {
				affiliations[i] = Integer.parseInt(dNodes.get(i).selectSingleNode("departmentId").getText());
			}
			
			authors.add(new Author(id, fName, lName, address, mobile, affiliations));
		}
		
		return authors;
	}
	
	public List<Department> readDepartments(List<Node> nodes){
		List<Department> departments = new ArrayList<>();
		for(Node node : nodes) {
			int id = Integer.parseInt(node.selectSingleNode("id").getText());
			String departmentName = node.selectSingleNode("name").getText();
			
			departments.add(new Department(id, departmentName));
		}
		
		return departments;
	}
	
	public List<Publication> readPublications(List<Node> nodes){
		List<Publication> publications = new ArrayList<>();
		for(Node node : nodes) {
			int id = Integer.parseInt(node.selectSingleNode("id").getText());
			String type = node.selectSingleNode("type").getText();
			String year = node.selectSingleNode("year").getText();
			String iSBN = node.selectSingleNode("ISBN").getText();
			String uRL = node.selectSingleNode("URL").getText();
			int citations = Integer.parseInt(node.selectSingleNode("citations").getText());
			
			List<Node> aNodes = node.selectNodes("authors");
			int[] authors = new int[aNodes.size()];
			for(int i=0; i<authors.length; i++) {
				authors[i] = Integer.parseInt(aNodes.get(i).selectSingleNode("authorId").getText());
			}
			
			publications.add(new Publication(id, type, year, authors, iSBN, uRL, citations));
		}
		
		return publications;
	}

}
