package mad.codeforcommunity;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Start_Project extends Activity {

	private static final String success = "Welcome to The AWS Browser Demo!";
	private static final String fail = "Load Failed. Please Try Restarting the Application.";
	

	protected Button s3Button;
	protected TextView welcomeText;
	
    public static AmazonClientManager clientManager = null;
    	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        s3Button = (Button) findViewById(R.id.main_storage_button);                           

        clientManager = new AmazonClientManager();

     	if ( Start_Project.clientManager.hasCredentials() ){
    		s3Button.setVisibility(View.VISIBLE);
    		this.wireButtons();
    	} 
        else {
    		this.displayCredentialsIssueAndExit();
    		welcomeText.setText(fail);
    	}       
    }
        
    private void wireButtons(){
       s3Button.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
    			startActivity(new Intent(Start_Project.this, S3Menu.class));
			}
		});
    }
        
    protected void displayCredentialsIssueAndExit() {
        AlertDialog.Builder confirm = new AlertDialog.Builder( this );
        confirm.setTitle("Credential Problem!");
        confirm.setMessage( "AWS Credentials not configured correctly.  Please review the README file." );
        confirm.setNegativeButton( "OK", new DialogInterface.OnClickListener() {
            public void onClick( DialogInterface dialog, int which ) {
            	Start_Project.this.finish();
            }
        } );
        confirm.show().show();                
    }

	
/*	
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
	*/
}
