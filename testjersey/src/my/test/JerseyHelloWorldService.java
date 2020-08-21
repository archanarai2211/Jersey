package my.test;


import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun.jersey.json.impl.provider.entity.JSONListElementProvider;
import com.sun.jersey.json.impl.provider.entity.JSONObjectProvider;
 
@Path("/show-on-screen")
@Consumes({ APPLICATION_JSON })
@Produces({ APPLICATION_JSON })
public class JerseyHelloWorldService
{
    @GET
    @Path("/{message}")
    public Response getMsg(@PathParam("message") String msg)
    {
        String output = "Message requested : " + msg;
        //Simply return the parameter passed as message
        return Response.status(200).entity(output).build();
    }
    
    @POST
	@Consumes({ APPLICATION_JSON })
	@Produces({ APPLICATION_JSON })
    @Path("/post")
    public Response postMsg(String tenants)
    {
    	 Gson gs = new Gson();
    	 JsonObject n = gs.fromJson(tenants, JsonObject.class);
    	 JsonArray a = n.getAsJsonArray("tenants").getAsJsonArray();
    	 StringBuilder str = new StringBuilder();
    	 for (int i = 0; i < a.size(); i++) { 
    		 str.append(a.get(i).getAsJsonObject().get("tenantid"));
    	 }
    	 System.out.println(str);
        String output =  tenants;
        //Simply return the parameter passed as message
        return Response.status(200).entity(output).build();
    }
}
