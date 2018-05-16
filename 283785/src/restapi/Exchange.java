package restapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/rates")
public class Exchange {
	
	RateHandler rateHandler = new RateHandler(); 
	
	@GET
	@Path(("{table}/{code}/{topCount}"))
	@Produces(MediaType.TEXT_PLAIN)
	public String getParamsTXT(@PathParam("table") String table, @PathParam("code") String code,
			@PathParam("topCount") Integer topCount) {

		Result resp = rateHandler.getAverage(table, code, topCount);
		return resp.toString();

	}
	
	@GET
	@Path(("{table}/{code}/{topCount}"))
	@Produces(MediaType.TEXT_XML)
	public Result getParamsXML(@PathParam("table") String table, @PathParam("code") String code,
			@PathParam("topCount") Integer topCount) {

		Result resp = rateHandler.getAverage(table, code, topCount);
		return resp;
	}
	
	@GET
	@Path(("{table}/{code}/{topCount}"))
	@Produces(MediaType.APPLICATION_JSON)
	public Result getParamsJSON(@PathParam("table") String table, @PathParam("code") String code,
			@PathParam("topCount") Integer topCount) {

		Result resp = rateHandler.getAverage(table, code, topCount);
		return resp;
	}
	
	@GET
	@Path(("{table}/{code}/{topCount}"))
	@Produces(MediaType.TEXT_HTML)
	public String getParamsHTML(@PathParam("table") String table, @PathParam("code") String code,
			@PathParam("topCount") Integer topCount) {

		Result resp = rateHandler.getAverage(table, code, topCount);
		return "<html><body><h1>"+resp.toString()+"</h1></body></html>";
	}
	
	
}
