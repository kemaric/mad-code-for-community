package mad.codeforcommunity;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class EventInfo extends Activity {

	TextView nm;
	TextView decription;
	TextView add;
	TextView conName;
	TextView host;
	ArrayList<String> values = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_info);

		Bundle extras = getIntent().getExtras();
		ArrayList<String> vals = extras.getStringArrayList("values");
		values.clear();
		values.addAll(vals);

		TextView host = (TextView) findViewById(R.id.host);
		host.setText(vals.get(0));

		TextView nm = (TextView) findViewById(R.id.name);
		nm.setText(vals.get(1));

		TextView decription = (TextView) findViewById(R.id.description);
		decription.setText(vals.get(2));

		TextView add = (TextView) findViewById(R.id.address);
		add.setText(vals.get(3));

		TextView conName = (TextView) findViewById(R.id.contact_name);
		conName.setText(vals.get(4));

	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.activity_event_info, menu);
//		return true;
//	}

}
