package mad.codeforcommunity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventView extends ListActivity {

	ArrayList<Event> events;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		View v = this.getCurrentFocus();
		
		Bundle extras = getIntent().getExtras();
		String day = extras.getString("date");
		
	//	HashSet<String> subscribed = viewSubscribed(v);

		// events = QueryDb.queryEvents(subscribed);

		// Test Events	
		events = new ArrayList<Event>();
		
		Random r = new Random();
		
		for (int i = 0; i < r.nextInt(10); i++) {
			
			// title
			// date
			// description
			// location
			// contact_name
			// contact_email
			// contact_phone
			
			String title= "Random Event Title"+Integer.toString(i);
			String date = day;
			String description = "Description of Event on:" ;
			String location = "1101 Test Rd, 20878 MD";
			String contactName = "tomLarken"+Integer.toString(i);
			String contactEmail = "tom.larken"+Integer.toString(i)+"@testEmail.com";
			String contactPhone = "301-999-9999";
			Event e = new Event(title,date,description,location,contactName,contactEmail,contactPhone);
			events.add(e);
		}

		ArrayList<String> eventTitle = new ArrayList<String>();

		for (int i = 0; i < events.size(); i++) {
			eventTitle.add(events.get(i).getTitle());
			
		}

		setListAdapter(new ArrayAdapter<String>(EventView.this,
				android.R.layout.simple_list_item_1, eventTitle));

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

//	public HashSet<String> viewSubscribed(View v) {
//		SQLiteDatabase db;
//		HashSet<String> results = new HashSet<String>();
//		db = openOrCreateDatabase("subscribed.db",
//				SQLiteDatabase.CREATE_IF_NECESSARY, null);
//		try {
//			String sql = "select NAME from tbl_Contain";
//			Cursor c = db.rawQuery(sql, null);
//
//			if (c != null) {
//				if (c.moveToFirst()) {
//					do {
//						String name = c.getString(c.getColumnIndex("NAME"));
//						results.add(name);
//					} while (c.moveToNext());
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return results;
//
//	}
}
