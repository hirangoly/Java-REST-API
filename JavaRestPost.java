package com.test.Sample;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;


/*public class HttpPostAPI {
	public static void main(String[] args) throws Exception {
		HttpClient client = new DefaultHttpClient();
	    HttpPost post = new HttpPost("http://www.foo.com/foo");

	    post.setHeader("Content-Type", "application/json");

	    List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
	    urlParameters.add(new BasicNameValuePair("rootURL", "http://www.subway.com"));
	    post.setEntity(new UrlEncodedFormEntity(urlParameters));
	    client.execute(post);
	}

}*/
public class HttpPostAPI {
 public static void main(String[] args) throws ClientProtocolException, IOException {
  HttpClient client = (HttpClient) new DefaultHttpClient();
  HttpPost post = new HttpPost("http://www.foo.com/foo");

  //post.setHeader("Content-Type", "application/json");

  
  //NameValuePair np = new BasicNameValuePair("rootURL", "hello");
  
  List<NameValuePair> urlParameters = new ArrayList<NameValuePair>(1);
  urlParameters.add(new BasicNameValuePair("rootURL", "hello"));
  HttpEntity entity = new UrlEncodedFormEntity(urlParameters, "utf-8");
  post.setEntity(entity);
  //post.setEntity(new UrlEncodedFormEntity(urlParameters,, "utf-8"));
  HttpResponse response=client.execute(post);
  BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
  String line = "";
  while ((line = rd.readLine()) != null) {
   System.out.println(line);
  }
 }
}
