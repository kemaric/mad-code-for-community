package mad.codeforcommunity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Start_Project extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_project);
		
		EditText projectName = (EditText) findViewById(R.id.etProject_Name);
		EditText projectDescription = (EditText) findViewById(R.id.etProject_Description);
		EditText projectLocation = (EditText) findViewById(R.id.etLocation);
		EditText projectTags = (EditText) findViewById(R.id.etTags);
		
		Button submit = (Button) findViewById(R.id.bSubmit_Project);
	}

}
