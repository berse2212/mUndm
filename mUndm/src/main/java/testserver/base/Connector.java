package testserver.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Connector {

	public <Q extends RequestBase, S extends ResponseBase> void doExercise(String name, Function<S, Q> function, Class<S> response, Class<Q> request)
			throws Exception {
		S dataResponse = (S) getURL("http://fb02tiitvm05.fh-muenster.de:80/api/exercises/"+name+"/data", response);
		
		Q result = function.apply(dataResponse);
		
		postURL("http://fb02tiitvm05.fh-muenster.de:80/api/exercises/"+name+"/result", result);
	}

	private void postURL(String url, RequestBase request) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader("x-auth-token", "7T_i2jHVi4BhNQ");
		httpPost.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		httpPost.setEntity(new StringEntity(objectMapper.writeValueAsString(request)));
		BufferedReader br1 = new BufferedReader(
                new InputStreamReader((httpPost.getEntity().getContent())));

		String input;
		System.out.println("Posting toServer .... \n");
		while ((input = br1.readLine()) != null) {
			System.out.println(input);
		}
		
		CloseableHttpResponse response = httpclient.execute(httpPost);
		try {
		    System.out.println(response.getStatusLine());

		    BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
		    
		    
		    
		} finally {
		    response.close();
		}
	}

	private <T extends ResponseBase> T getURL(String url, Class<T> responseClazz) throws IOException, ClientProtocolException, JsonParseException, JsonMappingException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader("x-auth-token", "7T_i2jHVi4BhNQ");
		
		T responseObject;
		CloseableHttpResponse response = httpclient.execute(httpGet);
		try {
		    System.out.println(response.getStatusLine());
		    HttpEntity entity = response.getEntity();

		    
		    ObjectMapper objectMapper = new ObjectMapper();
			responseObject = objectMapper.readValue(entity.getContent(), responseClazz);
		    
		    
		} finally {
		    response.close();
		}
		
		return responseObject;
	}

	
}
