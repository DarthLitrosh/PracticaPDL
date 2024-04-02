@Path("/usuarios/{usuarioId}/recomendaciones")
public class RecomendacionesResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerRecomendaciones(@PathParam("usuarioId") String usuarioId) {
        // Lógica para generar recomendaciones basadas en los últimos vinos añadidos,
        // los vinos mejor puntuados y los mejores vinos de los amigos.
        Recomendaciones recomendaciones = new Recomendaciones(); // Suponer la creación de recomendaciones
        return Response.ok(recomendaciones).build();
    }
}
