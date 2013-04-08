package mad.codeforcommunity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class CreateEvent extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_layout);
		String url = "http://mobileappdevelopersclub.com/greek/login-real.php";
		//Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		WebView webView = (WebView) findViewById(R.id.webView);
		//WebSettings settings = webView.getSettings();
		//settings.setJavaScriptEnabled(true);
		webView.loadUrl(url);
	}
}
