package mad.codeforcommunity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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

public class QueryDb {

	static JSONArray jArray;
	static String result = null;
	static InputStream is = null;
	static StringBuilder sb = null;
	static String Base_URL = "http://mobileappdevelopersclub.com/";

	protected static String queryDatabase(String phpScriptName,
			ArrayList<NameValuePair> searchKeys) throws HttpConnectionFailedThrowable {

		// http Post
		try {
			HttpClient httpclient = new DefaultHttpClient();
			String url = Base_URL + phpScriptName;
			HttpPost httppost = new HttpPost(url);
			httppost.setEntity(new UrlEncodedFormEntity(searchKeys));
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();
		} catch (Exception e) {
			Log.e("log_tag", "Error in http connection" + e.toString());
			throw new HttpConnectionFailedThrowable();
		}

		// convert response to string
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			sb = new StringBuilder();
			sb.append(reader.readLine() + "\n");

			String line = "0";
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result = sb.toString();
		} catch (Exception e) {
			Log.e("log_tag", "Error converting result " + e.toString());
		}

		// paring data
		return result;
	}


	protected static HashSet<String> getEventDays(String result) {

		
		String date = null;
		String[] dateSplit;
		int IndexForDay = 2; // year-month-day = [0]-[1]-[2]
		String day = null;

		HashSet<String>EventDays= new HashSet<String>();
		//ArrayList<String> EventDays = new ArrayList<String>();
		try {
			jArray = new JSONArray(result);
			JSONObject json_data = null;
			for (int i = 0; i < jArray.length(); i++) {
				json_data = jArray.getJSONObject(i);

				date = json_data.getString("date");
				dateSplit = date.split("-");// year-month-day
				day = dateSplit[IndexForDay];// indexForDay=2

				EventDays.add(day);

			}
		} catch (JSONException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		return EventDays;

	}

	protected static ArrayList<Event> getEvents(String result) {
		// title
		// date
		// description
		// location
		// contact_name
		// contact_email
		// contact_phone
		

		String title = null, date = null, description = null, location = null, contact_name = null, contact_email = null, contact_phone = null;

		ArrayList<Event> EventList = new ArrayList<Event>();
		try {
			jArray = new JSONArray(result);
			JSONObject json_data = null;
			for (int i = 0; i < jArray.length(); i++) {
				json_data = jArray.getJSONObject(i);
				title = json_data.getString("title");
				date = json_data.getString("date");
				description = json_data.getString("description");
				location = json_data.getString("location");
				contact_name = json_data.getString("contact_name");
				contact_email = json_data.getString("contact_email");
				contact_phone = json_data.getString("contact_phone");

				Event e = new Event( title,date,description, location,contact_name,contact_email,contact_phone);

				EventList.add(e);

			}
		} catch (JSONException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		//
		// HashMap<String, String> returnValues = new HashMap<String, String>();
		//
		// returnValues.put("title", title);
		// returnValues.put("date",date);
		// returnValues.put("description",description);
		// returnValues.put("location",location);
		// returnValues.put("contact_name",contact_name);
		// returnValues.put("contact_email",contact_email);
		// returnValues.put("contact_phone",contact_phone);

		return EventList;

	}
	/*
	 * protected static ArrayList<String> queryEvents(ArrayList<String> fields)
	 * {
	 * 
	 * ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	 * // nameValuePairs.add(new BasicNameValuePair("frat", //
	 * MainActivity.selectedFrat));
	 * 
	 * // http post
	 * 
	 * try { HttpClient httpclient = new DefaultHttpClient(); String url =
	 * "http://mobileappdevelopersclub.com/event_search.php"; HttpPost httppost
	 * = new HttpPost(url); httppost.setEntity(new
	 * UrlEncodedFormEntity(nameValuePairs)); HttpResponse response =
	 * httpclient.execute(httppost); HttpEntity entity = response.getEntity();
	 * is = entity.getContent(); } catch (Exception e) { Log.e("log_tag",
	 * "Error in http connection" + e.toString()); } // convert response to
	 * string try { BufferedReader reader = new BufferedReader(new
	 * InputStreamReader( is, "iso-8859-1"), 8); sb = new StringBuilder();
	 * sb.append(reader.readLine() + "\n");
	 * 
	 * String line = "0"; while ((line = reader.readLine()) != null) {
	 * sb.append(line + "\n"); } is.close(); result = sb.toString(); } catch
	 * (Exception e) { Log.e("log_tag", "Error converting result " +
	 * e.toString()); } // paring data
	 * 
	 * fields = getGreekInfo(result, fields);
	 * 
	 * return fields; }
	 */

}
