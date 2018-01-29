package hackerhank.advanced;

public class Singleton {
	
	private static Singleton singleton;
	private Singleton() {}
	
	public String str;
	
	public static Singleton getSingleInstance() {
		if (singleton == null) {
			singleton = new Singleton(); 
		}
		return singleton;
	}

}
