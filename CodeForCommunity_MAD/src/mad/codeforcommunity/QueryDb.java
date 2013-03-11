package mad.codeforcommunity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader; 
import java.util.ArrayList; 
import org.apache.http.HttpEntity; 
import org.apache.http.HttpResponse; 
import org.apache.http.NameValuePair; 
import org.apache.http.client.HttpClient; 
import org.apache.http.client.entity.UrlEncodedFormEntity; 
import org.apache.http.client.methods.HttpPost; 
import org.apache.http.impl.client.DefaultHttpClient; 
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray; 
import org.json.JSONException; 
import org.json.JSONObject; 
import android.app.ListActivity; 
import android.content.Intent;
import android.net.ParseException; 
import android.os.Bundle; 
import android.util.Log; 
import android.widget.Toast;

public class QueryDb  {

	static JSONArray jArray; 
	static String result = null; 
	static InputStream is = null; 
	static StringBuilder sb=null;


	protected static ArrayList<String> queryGreekGroups(ArrayList<String> fields, int id) {


		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("frat", Integer.toString(id)));
		
		//http post
		
		
		try{
			HttpClient httpclient = new DefaultHttpClient();
			String url = "http://mobileappdevelopersclub.com/greek_search.php";
			HttpPost httppost = new HttpPost(url);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();
		}catch(Exception e){
			Log.e("log_tag", "Error in http connection"+e.toString());
		}
		//convert response to string
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			sb = new StringBuilder();
			sb.append(reader.readLine() + "\n");

			String line="0";
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e){
			Log.e("log_tag", "Error converting result "+e.toString());
		}
		//paring data


		fields = getGreekInfo(result, fields);
		


		return fields;
	}

	protected static ArrayList<String> getGreekInfo(String result, ArrayList<String> toBeReturned) {
		String id = null;
		String name = null;
		String description= null;
		String address = null;
		String contactNm = null;
		String contactEm = null;
		try{
			jArray = new JSONArray(result);
			JSONObject json_data=null;
			for(int i=0;i<jArray.length();i++){
				json_data = jArray.getJSONObject(i);
				id = json_data.getString("id");
				name=json_data.getString("name");
				description=json_data.getString("description");
				address = json_data.getString("address");
				contactNm = json_data.getString("contact");
				contactEm = json_data.getString("email");

			}
		}
		catch(JSONException e1){
			e1.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}


		toBeReturned.add(id);
		toBeReturned.add(name);
		toBeReturned.add(description);
		toBeReturned.add(address);
		toBeReturned.add(contactNm);
		toBeReturned.add(contactEm);

		return toBeReturned;



	}

	
	protected static ArrayList<String> queryEvents(ArrayList<String> fields) {


		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		//nameValuePairs.add(new BasicNameValuePair("frat", MainActivity.selectedFrat));
		
		//http post
		
		
		try{
			HttpClient httpclient = new DefaultHttpClient();
			String url = "http://mobileappdevelopersclub.com/event_search.php";
			HttpPost httppost = new HttpPost(url);
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();
		}catch(Exception e){
			Log.e("log_tag", "Error in http connection"+e.toString());
		}
		//convert response to string
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			sb = new StringBuilder();
			sb.append(reader.readLine() + "\n");

			String line="0";
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result=sb.toString();
		}catch(Exception e){
			Log.e("log_tag", "Error converting result "+e.toString());
		}
		//paring data


		fields = getGreekInfo(result, fields);
		


		return fields;
	}




}
