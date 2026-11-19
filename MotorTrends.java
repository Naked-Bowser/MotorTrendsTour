package com.motor.motortrends;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpClient.Version;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Builder;
import java.io.IOException;
import java.lang.InterruptedException;
import java.lang.StringBuilder;
import java.lang.System;

//Caller makes a request and expects a response from the client http callee upon success!

public class MotorTrends{
	public static void main(String[] args){
		String URL = "https://www.rockauto.com/en/catalog/ford";
		final int PORT = 80;
		try{
		//Http client is decalred and instantiated
		//PORT biding to Inetsocket address IPV4
		HttpClient client = HttpClient.newBuilder()
			.version(Version.HTTP_1_1)
			.followRedirects(Redirect.NORMAL)
			.build();
		if(client.isTerminated())
			throw new IOException("Input/Output Error!");
		//Request decalred and instantiated
		HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create(URL))
			.build();

		//String of response expects response from httpclient header packets
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		System.out.println(response.statusCode());
		System.out.println(response.body());
		throw new InterruptedException("Interrupted Exception!");
		}catch(IOException error){
			System.err.println(error.getMessage());
			System.err.println(error.getStackTrace());
		}catch(InterruptedException error){
			System.err.println(error.getMessage());
			System.err.println(error.getStackTrace());
		}
	}
}//end class
