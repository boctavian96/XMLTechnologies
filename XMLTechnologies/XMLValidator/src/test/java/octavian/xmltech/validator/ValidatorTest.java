package octavian.xmltech.validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidatorTest {
	
	public static final String DB_SCHEMA="databaseSchema.xsd";
	
	@Test
	public void testOriginal() {
		//database original NU ARE NAMESPACE.
		//org.xml.sax.SAXParseException; systemId: file:/C:/Users/octavian.bodnariu/git/XMLTechnologies/XMLTechnologies/XMLValidator/database.xml; lineNumber: 4; columnNumber: 18; cvc-complex-type.2.4.a: Invalid content was found starting with element 'authors'. One of '{"http://www.example.org/NewXMLSchema":authors}' is expected.
		assertFalse(XMLValidator.validate("database.xml", DB_SCHEMA));
	}
	
	@Test
	public void testFail() {
		assertFalse(XMLValidator.validate("databaseFail.xml", DB_SCHEMA));
	}
	
	@Test
	public void testSuccess() {
		assertTrue(XMLValidator.validate("databaseGenerated.xml", DB_SCHEMA));
	}

}
