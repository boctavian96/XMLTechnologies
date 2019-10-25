package octavian.xmltech.validator;

import java.io.File;
import java.io.IOError;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLValidator {
	public static boolean validate(String xmlFile, String schemaFile) {
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		
		try {
			Schema schema = schemaFactory.newSchema(new File(schemaFile));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(xmlFile)));
			return true;
			
		}catch(SAXException | IOException e) {
			//e.printStackTrace();
			return false;
		}
	}
}
