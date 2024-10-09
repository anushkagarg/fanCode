package Request;

public class Request {
	public static String BaseURI() {
		String baseuri= "http://jsonplaceholder.typicode.com/";
		return baseuri;
	}
	
	public static String ResourceUsers() {
		String resource = "/users";
		return resource;
	}
	
	public static String ResourceTodo() {
		String resource = "/todos";
		return resource;
	}

}
