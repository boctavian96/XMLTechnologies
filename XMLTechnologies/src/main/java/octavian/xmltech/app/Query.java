package octavian.xmltech.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.plaf.SliderUI;

import octavian.xmltech.datamodel.Author;
import octavian.xmltech.datamodel.Database;
import octavian.xmltech.datamodel.Publication;

public class Query {
	private Database db;
	
	public Query(Database db) {
		this.db=db;
	}
	
	/*
	 * Lista de publicatii in funtie de autor.
	 */
	public List<Publication> selectForAuthors(int authorId){
		List<Author> authors = db.getAuthors();
		List<Publication> publications = db.getPublications();
		
		//Author selectedAuthor = authors.stream().filter( author -> authorId == author.getId()).collect(Collectors.toList()).get(0);
		//System.out.println(selectedAuthor);
		
		return publications.stream().filter( publication -> publication.hasAuthor(authorId)).collect(Collectors.toList());
	}
	
	/*
	 * Lista articolelor pe categorii.
	 */
	public List<Publication> selectCategory(String publicationType){
		List<Publication> publications = db.getPublications();
		
		return publications.stream().filter( publication -> publicationType.equals(publication.getType())).collect(Collectors.toList());
	}
	
	//Lista articolelor pe Facultati.
	public List<Publication> selectForUniversity(int departmentId){
		List<Author> authors = db.getAuthors().stream().filter(author -> author.hasAffiliation(departmentId)).collect(Collectors.toList());
		List<Publication> selectedPublications = new ArrayList<>();
		
		for(Author author : authors) {
			selectedPublications.addAll(selectForAuthors(author.getId()));
		}
		
		return selectedPublications;
	}
}
