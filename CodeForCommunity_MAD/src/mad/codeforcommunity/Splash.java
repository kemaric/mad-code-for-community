package mad.codeforcommunity;


import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.format.Time;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class Splash extends Activity {

	
	static final int PICK_DATE_REQUEST = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_splash);
		Thread timer = new Thread(){
			public void run() {
				try {
					sleep(2000);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					Time today = new Time(Time.getCurrentTimezone());
					
					Intent intent = new Intent(Splash.this, CalendarView.class);
					
		    		intent.putExtra("date", today.year+"-"+today.month+"-"+today.monthDay);
		    		startActivityForResult(intent, PICK_DATE_REQUEST);				
				}
			}
		};
		timer.start();

	}
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.layout.activity_splash, menu);
		return true;
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
