package mad.codeforcommunity;

import java.util.ArrayList;

public class Event {
	// title
	// date
	// description
	// location
	// contact_name
	// contact_email
	// contact_phone

	private String title;
	private String date;
	private String description;
	private String location;
	private String contactName;
	private String contactEmail;
	private String contactPhone;


	/**
	 * @param title
	 * @param date
	 * @param description
	 * @param location
	 * @param contactName
	 * @param contactEmail
	 * @param contactPhone
	 */
	public Event(String title, String date, String description,
			String location, String contactName, String contactEmail,
			String contactPhone) {
		this.title = title;
		this.date = date;
		this.description = description;
		this.location = location;
		this.contactName = contactName;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
	}


	//For testing only!
	/**
	 * @param t
	 * @param d
	 */
	public Event(String t, String d) {
		this.title= t;
		this.date= d;
		
		// TODO Auto-generated constructor stub
	}


	public String getTitle() {
		return title;
	}


	public String getDate() {
		return date;
	}


	public String getDescription() {
		return description;
	}


	public String getLocation() {
		return location;
	}


	public String getContactName() {
		return contactName;
	}


	public String getContactEmail() {
		return contactEmail;
	}


	public String getContactPhone() {
		return contactPhone;
	}





	
	public static ArrayList<String> listOfEventInfo(Event e) {
		ArrayList<String> info = new ArrayList<String>();
	
		info.add(e.title);
		info.add(e. date);
		info.add(e.description);
		info.add(e.location);
		info.add(e.contactName);
		info.add(e.contactEmail);
		info.add(e.contactPhone);
		
		return info;
	}



	
	
	
}
