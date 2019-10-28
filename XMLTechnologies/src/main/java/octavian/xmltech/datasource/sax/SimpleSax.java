package octavian.xmltech.datasource.sax;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import octavian.xmltech.app.Config;

public class SimpleSax {
	public void parse(String element, int id) {
		File database = new File(Config.DATABASE_FILE);
		SAXParserFactory factory = SAXParserFactory.newInstance();
		//ElementHandler elementHandler = new ElementHandler();
		SimpleQueryHandler queryHandler = new SimpleQueryHandler(element, id);

		SAXParser parser;
		try {
			parser = factory.newSAXParser();
			parser.parse(database, queryHandler);
		}catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
}
