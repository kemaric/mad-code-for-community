package mad.codeforcommunity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class EventView extends ListActivity {

	public Handler handler;
	public ArrayList<Event> events;
	public String day;
	public ArrayAdapter adapter;
	public final Activity curr = this;


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View v = this.getCurrentFocus();
		
		Bundle extras = getIntent().getExtras();
		day = extras.getString("date");
		
	
		// events = QueryDb.queryEvents(subscribed);

		// Test Events	
		events = new ArrayList<Event>();
		
		handler = new Handler();
	    handler.post(loadEventsList);
		
		
//		Random r = new Random();
//		// title
//			// date
//			// description
//			// location
//			// contact_name
//			// contact_email
//			// contact_phone
//		for (int i = 0; i < r.nextInt(10); i++) {
//
//			String title= "Random Event Title"+Integer.toString(i);
//			String date = day;
//			String description = "Description of Event on:" ;
//			String location = "1101 Test Rd, 20878 MD";
//			String contactName = "tomLarken"+Integer.toString(i);
//			String contactEmail = "tom.larken"+Integer.toString(i)+"@testEmail.com";
//			String contactPhone = "301-999-9999";
//			Event e = new Event(title,date,description,location,contactName,contactEmail,contactPhone);
//			events.add(e);
//		}
//
//		
//		
//		
//		ArrayList<String> eventTitle = new ArrayList<String>();
//
//		for (int i = 0; i < events.size(); i++) {
//			eventTitle.add(events.get(i).getTitle());
//			
//		}
//
//		//setListAdapter();
//		adapter= new ArrayAdapter<String>(EventView.this,android.R.layout.simple_list_item_1, eventTitle);
				

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.layout.activity_event_view, menu);
		return true;
	}

	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		Event event = events.get(position);
		ArrayList<String> data = Event.listOfEventInfo(event);
		Bundle extras = new Bundle();
		extras.putStringArrayList("values", data);
		Intent intent = new Intent(EventView.this, EventInfo.class);
		intent.putExtras(extras);
		startActivity(intent);
	}

	public Runnable loadEventsList = new Runnable() {
		//query database to find days in this month that have events
		public void run() {
			String JSONString=null;
			//	events.clear();	
			
			//Code should be correct but DB calls are not tested
 
			ArrayList<NameValuePair> argrsList= new ArrayList<NameValuePair>();			
			argrsList.add(new BasicNameValuePair("date",day));
		try {
			JSONString=QueryDb.queryDatabase("events_by_day.php",argrsList );//returns JSON String of days in the month that have events, String needs to be parsed
			events.addAll(QueryDb.getEvents(JSONString));

			
//			Random r = new Random();
//			// title
//				// date
//				// description
//				// location
//				// contact_name
//				// contact_email
//				// contact_phone
//			for (int i = 0; i < r.nextInt(10); i++) {
//	
//				String title= "Random Event Title"+Integer.toString(i);
//				String date = day;
//				String description = "Description of Event on:" ;
//				String location = "1101 Test Rd, 20878 MD";
//				String contactName = "tomLarken"+Integer.toString(i);
//				String contactEmail = "tom.larken"+Integer.toString(i)+"@testEmail.com";
//				String contactPhone = "301-999-9999";
//				Event e = new Event(title,date,description,location,contactName,contactEmail,contactPhone);
//				events.add(e);
//			}
			
			ArrayList<String> eventTitle = new ArrayList<String>();

			for (int i = 0; i < events.size(); i++) {
				eventTitle.add(events.get(i).getTitle());
	
			}

			setListAdapter(new ArrayAdapter<String>(EventView.this, R.layout.my_simple_event_1, eventTitle));				
		}catch (HttpConnectionFailedThrowable e) {
				Toast.makeText(curr, "No Internet Connection", 5000).show();
			}
//
//			setListAdapter(adapter);
//			adapter.setItems(eventTitle);
//			adapter.notifyDataSetChanged();
		}
	};
}
