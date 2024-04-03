package Soso.src.main.java;
@Path("/vinos")
public class VinoResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearVino(Vino vino) {
        // Lógica para añadir el vino a la base de datos
        return Response.status(Response.Status.CREATED).entity(vino).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerVino(@PathParam("id") int id) {
        // Lógica para obtener el vino de la base de datos
        Vino vino = new Vino(); // Supongamos que este método recupera el vino por ID
        return Response.ok(vino).build();
    }
    
    // Más métodos para actualizar y eliminar vinos, etc.
}
