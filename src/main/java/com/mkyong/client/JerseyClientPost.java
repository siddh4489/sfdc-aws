package com.mkyong.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientPost {

	public static void main(String[] args) {

		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/RESTfulExample/rest/json/metallica/posting");

			String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";
                        //String input = "hello";
                       //  String jsonstr = "{param1=\"hello\",param2=\"hello2\"}";
                       // client.create(jsonstr);

			ClientResponse response = webResource.type("application/json")
					.post(ClientResponse.class, input);
                        System.out.println("---response.getStatus()----"+response.getStatus());

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
