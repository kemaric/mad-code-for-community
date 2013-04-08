package mad.codeforcommunity;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class EventInfo extends Activity {

	TextView title;
	TextView date;
	TextView description;
	TextView location;
	TextView contact_name;
	TextView contact_email;
	TextView contact_phone;

//	TextView nm;
//	TextView decription;
//	TextView add;
//	TextView conName;
//	TextView host;
	ArrayList<String> values = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_info);

		Bundle extras = getIntent().getExtras();
		ArrayList<String> vals = extras.getStringArrayList("values");
		values.clear();
		values.addAll(vals);

		title = (TextView) findViewById(R.id.title);
		title.setText(vals.get(0));

		date = (TextView) findViewById(R.id.date);
		date.setText(vals.get(1));

		description = (TextView) findViewById(R.id.description);
		description.setText(vals.get(2));

		location = (TextView) findViewById(R.id.location);
		location.setText(vals.get(3));

		contact_name = (TextView) findViewById(R.id.contact_name);
		contact_name.setText(vals.get(4));
		
		 contact_email = (TextView) findViewById(R.id. contact_email);
		 contact_email.setText(vals.get(5));
		
		 contact_phone = (TextView) findViewById(R.id.contact_phone);
		 contact_phone.setText(vals.get(6));

	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.activity_event_info, menu);
	// return true;
	// }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.monthI:
			Time today = new Time(Time.getCurrentTimezone());
			Intent intent = new Intent(this, CalendarView.class);
			intent.putExtra("date", today.year+"-"+today.month+"-"+today.monthDay);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivityForResult(intent, 1);	
			break;
		case R.id.dayI: 
			setContentView(R.layout.calendar_item);;
			today = new Time(Time.getCurrentTimezone());
			intent = new Intent(this, EventView.class);
			intent.putExtra("date", today.year+"-"+today.month+"-"+today.monthDay);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case R.id.createI:
			setContentView(R.layout.create_layout);
			Intent createInt = new Intent(this, CreateEvent.class );
			startActivity(createInt);
			break;
		case R.id.refreshI:
			//this doesnt have to refresh here since event wont change 
			break;
		}
		return true;
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
		// TODO Auto-generated method stub
		super.onOptionsMenuClosed(menu);
	}

}
