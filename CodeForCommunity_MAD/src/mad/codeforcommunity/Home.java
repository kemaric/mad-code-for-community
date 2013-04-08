package mad.codeforcommunity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Home extends Activity{
	Button create, event;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		create = (Button) findViewById(R.id.butt2);
		event = (Button) findViewById(R.id.butt1);
		create.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Uri uri = Uri.parse("www.google.com");
				Intent intent = new Intent(Intent.ACTION_VIEW,uri);
				startActivity(intent);
			}

		});
		event.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Home.this,CalendarView.class);
				startActivity(intent);
			}
		});
	}

}
