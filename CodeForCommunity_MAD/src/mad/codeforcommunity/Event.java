package mad.codeforcommunity;

import java.util.ArrayList;

public class Event {
	
	String host;
	String name;
	String description;
	String address;
	String contact;
	
	
	public Event(String h, String n, String d, String a, String c) {
		this.host = h;
		this.name = n;
		this.description = d;
		this.address = a;
		this.contact = c;
	}
	
	
	public static ArrayList<String> listOfEventInfo(Event e) {
		ArrayList<String> info = new ArrayList<String>();
		
		info.add(e.host);
		info.add(e.name);
		info.add(e.description);
		info.add(e.address);
		info.add(e.contact);
		
		return info;
	}
	
	
	
	
}
