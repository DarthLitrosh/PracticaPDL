package sos.practica1;

import java.time.temporal.ChronoUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.DELETE;
import javax.persistence.EntityManager;


public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreUsuario;
    private LocalDate fechaNacimiento;
    private String correoElectronico;
    // Getters y setters
    
    public Response agregarUsuario(Usuario usuario) {
        if (ChronoUnit.YEARS.between(usuario.getFechaNacimiento(), LocalDate.now()) < 18) {
            return Response.status(Response.Status.BAD_REQUEST).entity("El usuario es menor de edad.").build();
        }
        // Persistir el usuario en la base de datos
        entityManager.persist(usuario);
        return Response.status(Response.Status.CREATED).entity(usuario).build();
    }
    
    public Response obtenerUsuario(@PathParam("id") Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(usuario).build();
    }
    
    public Response actualizarUsuario(@PathParam("id") Long id, Usuario usuario) {
        if (entityManager.find(Usuario.class, id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        usuario.setUsuarioId(id);
        entityManager.merge(usuario);
        return Response.ok(usuario).build();
    }
    
    public Response eliminarUsuario(@PathParam("id") Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        if (usuario != null) {
            entityManager.remove(usuario);
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    public Response listarUsuarios(@QueryParam("nombre") String nombre) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
        Root<Usuario> usuario = cq.from(Usuario.class);
        cq.select(usuario);
        if (nombre != null) {
            cq.where(cb.like(usuario.get("nombre_usuario"), "%" + nombre + "%"));
        }
        List<Usuario> usuarios = entityManager.createQuery(cq).getResultList();
        return Response.ok(usuarios).build();
    }
    
}
