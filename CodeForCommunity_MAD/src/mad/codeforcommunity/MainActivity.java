package mad.codeforcommunity;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Activity curr = this;

		Button startProject = (Button) findViewById(R.id.bStart_Project);
		startProject.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					Class startClass = Class.forName("mad.codeforcommunity.Start_Project");
					Intent projectStart = new Intent(MainActivity.this, startClass);
					startActivity(projectStart);
				} catch (ClassNotFoundException e) {
					Toast.makeText(curr ,"An Error Occured", 5000).show();
					e.printStackTrace();
				}
			}
		});
		
		Button findProject = (Button) findViewById(R.id.bFind);
		findProject.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					Class startClass = Class.forName("mad.codeforcommunity.Find_Project");
					Intent projectStart = new Intent(MainActivity.this, startClass);
					startActivity(projectStart);
				} catch (ClassNotFoundException e) {
					Toast.makeText(curr ,"An Error Occured", 5000).show();
					e.printStackTrace();
				}

			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}