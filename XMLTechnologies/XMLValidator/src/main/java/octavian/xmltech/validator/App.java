package octavian.xmltech.validator;

public class App {
	
	// /XMLValidator/src/main/resources/xml/database.xml /XMLValidator/src/main/resources/xsd/databaseSchema.xsd

	public static void main(String[] args) throws Exception  {
		
		if(args.length < 2) {
			throw new Exception(App.help());
		}else {
			XMLValidator.validate(args[0], args[1]);
		}

	}
		
	public static String help() {
		return "TODO";
	}

}
