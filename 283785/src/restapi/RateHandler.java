package restapi;

import java.io.StringReader;
import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class RateHandler {

	private AverageCounter averageCounter = new AverageCounter();
	
	public Result getAverage(String table, String code, Integer topCount) {
	
		Client client = ClientBuilder.newClient();
		
		URI uri = UriBuilder.fromUri("http://api.nbp.pl/api/exchangerates/rates").build();
		WebTarget webTarget = client.target(uri);
		
		webTarget = webTarget.path(table+"/"+code+"/last/"+topCount.toString());
		
		String xmlAnswer = webTarget.request().accept(MediaType.TEXT_XML).get(String.class);
		
		ExchangeRatesSeries exchangeRatesSeries = new ExchangeRatesSeries();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ExchangeRatesSeries.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(xmlAnswer);
			exchangeRatesSeries = (ExchangeRatesSeries) jaxbUnmarshaller.unmarshal(reader); 
		} catch (JAXBException e) {
		
			e.printStackTrace();
		
		}
		
		/*uri =  UriBuilder.fromUri("http://api.nbp.pl/api/exchangerates/rates/"+table+"/"+code+"/last/"+topCount.toString()+"/?format=json").build();	
		webTarget = client.target(uri);
		String jsonAnswer = webTarget.request().accept(MediaType.TEXT_PLAIN).get(String.class);
		*/
		System.out.println(averageCounter);
		Float avg = averageCounter.getAverage(exchangeRatesSeries);
		Result result = new Result(exchangeRatesSeries.getCurrency(),avg);
		
		return result;
	}

}
