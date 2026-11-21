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
import java.util.regex.Matcher;

//Caller makes a request and expects a response from the client http callee upon success!
public class MotorTrends{
	public static StringBuilder Prototype(StringBuilder build){
		//Create a regular expression:
                String URL = "https://www.rockauto.com/en/catalog";
		//boolean b = Pattern.macthes("\D+",URL);//boolean mactches?
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
                //Matcher with pattern. Takes perl syntax regular
                //boolean b = Pattern.matches("\D+",URL);
//String of response expects response from httpclient header packets
		
                HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		build.append(new StringBuilder(response.body()));
		System.out.println(response.headers());
		System.out.println(response.uri());
                System.out.println(response.statusCode());

                }catch(IOException error){
                        System.err.println(error.getMessage());
                        System.err.println(error.getStackTrace());
                }catch(InterruptedException error){
                        System.err.println(error.getMessage());
                        System.err.println(error.getStackTrace());
                }
		return new StringBuilder(build.toString());
	}


	public static void main(String[] args){
		StringBuilder builder = new StringBuilder();
		//retrieve arugments from user and builder url.
		Prototype(builder);
	}
}//end class
