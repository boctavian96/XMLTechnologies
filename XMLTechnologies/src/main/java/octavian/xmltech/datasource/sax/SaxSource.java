package octavian.xmltech.datasource.sax;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import octavian.xmltech.app.Config;
import octavian.xmltech.datamodel.Database;
import octavian.xmltech.datasource.DataSource;

public class SaxSource implements DataSource{

	@Override
	public Database readSource() {
		
		File database = new File(Config.DATABASE_FILE);
		SAXParserFactory factory = SAXParserFactory.newInstance();
		ElementHandler elementHandler = new ElementHandler();

		SAXParser parser;
		try {
			parser = factory.newSAXParser();
			parser.parse(database, elementHandler);
		}catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		return new Database(elementHandler.getAuthors(), elementHandler.getDepartments(), elementHandler.getPublications());

	}

}
