package octavian.xmltech.app;

import static org.junit.Assert.*;

import org.dom4j.io.SAXReader;
import org.junit.Test;

import octavian.xmltech.datasource.DataSource;
import octavian.xmltech.datasource.sax.SimpleSax;

public class SimpleQueryTest {

	@Test
	public void testSimpleAuthor() {
		SimpleSax simpleSax = new SimpleSax();
		simpleSax.parse("author", 1);
	}
	
	@Test
	public void testSimpleDepartment() {
		SimpleSax simpleSax = new SimpleSax();
		simpleSax.parse("department", 1);
	}
	
	@Test
	public void testSimplePublication() {
		SimpleSax simpleSax = new SimpleSax();
		simpleSax.parse("publication", 1);
	}

}
