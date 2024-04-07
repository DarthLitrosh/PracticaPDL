package sos.practica1;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.DELETE;


public class UsuarioResource {
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarUsuario(Usuario usuario) {
        // Aquí iría la lógica para verificar la edad del usuario y agregarlo a la base de datos
        // Si el usuario es menor de edad, retorna un mensaje de error
        return Response.status(Response.Status.CREATED).entity(usuario).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerUsuario(@PathParam("id") int id) {
        // Aquí se recuperaría el usuario de la base de datos usando el id
        // Y luego se devuelve el usuario encontrado
        return Response.ok(usuario).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarUsuario(@PathParam("id") int id, Usuario usuario) {
        // Actualiza los datos del usuario en la base de datos
        return Response.ok(usuario).build();
    }
    
    @DELETE
    public Response eliminarUsuario(@PathParam("id") int id) {
        // Aquí se eliminaría el usuario de la base de datos
        return Response.noContent().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarUsuarios(@QueryParam("nombre") String nombre) {
        // Aquí se recuperaría la lista de usuarios, opcionalmente filtrada por nombre
        return Response.ok(listaUsuarios).build();
    }
    
}
