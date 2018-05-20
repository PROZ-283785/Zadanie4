package restapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/rates")
public class Exchange {

	RateHandler rateHandler = new RateHandler();

	@GET
	@Path(("{table}/{code}/{topCount}"))
	@Produces(MediaType.TEXT_HTML)
	public Response getParamsHTML(@PathParam("table") String table, @PathParam("code") String code,
			@PathParam("topCount") Integer topCount) {

		Result resp = rateHandler.getAverage(table, code, topCount);
		String response = "<html><body><h1>" + resp.toString() + "</h1></body></html>";
		return Response.status(200).entity(response).build();
	}

	@GET
	@Path(("{table}/{code}/{topCount}"))
	@Produces(MediaType.TEXT_PLAIN)
	public Response getParamsTXT(@PathParam("table") String table, @PathParam("code") String code,
			@PathParam("topCount") Integer topCount) {

		Result resp = rateHandler.getAverage(table, code, topCount);
		// return resp.toString();
		return Response.status(200).entity(resp.toString()).build();

	}

	@GET
	@Path(("{table}/{code}/{topCount}"))
	@Produces(MediaType.TEXT_XML)
	public Response getParamsXML(@PathParam("table") String table, @PathParam("code") String code,
			@PathParam("topCount") Integer topCount) {

		Result resp = rateHandler.getAverage(table, code, topCount);
		// return resp;
		return Response.status(200).entity(resp).build();
	}

	@GET
	@Path(("{table}/{code}/{topCount}"))
	@Produces(MediaType.APPLICATION_JSON)
	public Response getParamsJSON(@PathParam("table") String table, @PathParam("code") String code,
			@PathParam("topCount") Integer topCount) {

		Result resp = rateHandler.getAverage(table, code, topCount);
		// return resp;
		return Response.status(200).entity(resp).build();
	}

}
