package control;

import entidades.Cliente;
import entidades.Distrito;
import entidades.Domicilio;
import entidades.Plan;
import entidades.Profesion;
import entidades.Solicitud;
import entidades.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import negocio.GestorListasLocal;
import negocio.GestorUsuarioLocal;

@ManagedBean(name = "usuarioControl")
@ViewScoped
public class UsuarioControl implements Serializable {

    private Usuario usuario;
    private Cliente cliente;
    private Plan plan;
    private String login = "";
    private String password = "";
    private String password2 = "";
    private Date fechaNacimiento = new Date();
    private String profesionSelec;
    private String distritoSelec;
    private Domicilio domicilio;
    private Long idDomicilio;
    private Long idCliente;
    private Profesion profesion;
    private Distrito distrito;
    private String fechanace;
    private String estadoCivil;
    private List<Cliente> clientes;
    private List<Cliente> filtroClientes;
    private List<Plan> planes;
    private List<String> cuiles = new ArrayList<String>();
    private String clienteCredito;
    private Solicitud solicitud;
    
    @EJB
    private GestorListasLocal gestorListas;
    @EJB
    private GestorUsuarioLocal gestorUsuario;

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    
    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
    
    public String getClienteCredito() {
        return clienteCredito;
    }

    public void setClienteCredito(String clienteCredito) {
        this.clienteCredito = clienteCredito;
    }

    public List<String> getCuiles() {
        cuiles = gestorListas.listaCuil();
        return cuiles;
    }

    public void setCuiles(List<String> cuiles) {
        this.cuiles = cuiles;
    }
    
    public List<Plan> getPlanes() {
        planes = gestorListas.planes();
        return planes;
    }

    public void setPlanes(List<Plan> planes) {
        this.planes = planes;
    }
    
    public List<Cliente> getFiltroClientes() {
        return filtroClientes;
    }

    public void setFiltroClientes(List<Cliente> filtroClientes) {
        this.filtroClientes = filtroClientes;
    }

    public List<Cliente> getClientes() {
        clientes = gestorListas.clientes();
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getFechanace() {
        return fechanace;
    }

    public void setFechanace(String fechanace) {
        this.fechanace = fechanace;
    }

    public String getDistritoSelec() {
        return distritoSelec;
    }

    public void setDistritoSelec(String distritoSelec) {
        this.distritoSelec = distritoSelec;
    }

    public Long getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Long idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getProfesionSelec() {
        return profesionSelec;
    }

    public void setProfesionSelec(String profesionSelec) {
        this.profesionSelec = profesionSelec;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    // TRANSFORMA LA FECHA (UTIL.DATE) A SQL
    public java.sql.Date sqlDate(java.util.Date fecha) {
        return new java.sql.Date(fecha.getTime());
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public void eliminarCliente() {
        if (cliente.getIdCliente() == null || cliente.getIdCliente() < 0) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error al eliminar Cliente.", "No se brindo un ID.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {

        Cliente clienteSelec = gestorUsuario.buscarCliente(cliente.getIdCliente());
        gestorUsuario.eliminarCliente(clienteSelec);
        Domicilio domicilioSelec = gestorUsuario.buscarDomicilio(clienteSelec.getDomicilioId().getIdDomicilio());
        gestorUsuario.eliminarDomicilio(domicilioSelec);
        filtroClientes = gestorListas.clientes();
        FacesMessage msg = new FacesMessage("Resultado", "Cliente eliminado con exito");                    
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    private void crearDomicilio() {
        distrito = gestorUsuario.insertarDistrito(distritoSelec);
        domicilio.setDistritoId(distrito);
        gestorUsuario.registrarDomicilio(domicilio);
    }

    public String crearCliente() {
        crearDomicilio();
//        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//        fechanace = df.format(fechaNacimiento);        
        profesion = gestorUsuario.insertarProfesion(profesionSelec);
        cliente.setDomicilioId(domicilio);
        cliente.setProfesionId(profesion);
//        cliente.setFechaNacimiento(FechaConverter.convertToDate(fechanace));
        gestorUsuario.registrarCliente(cliente);
//            gestorUsuario.registrarCliente(cuil, apellido, nombre, telefono, celular, email, fechaNace, 
//                sueldo, estadoCivil, calle, nro, distrito, piso, dpto, profesion, domicilio);        
        return "clienteCreado.xhtml";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioControl() {
        usuario = new Usuario();
        cliente = new Cliente();
        clientes = new ArrayList<Cliente>();
        plan = new Plan();
        planes = new ArrayList<Plan>();
    }

    public String validaUsuario() {
        String destino = null;
        if (login.equals("admin") && (password.equals("1234"))) {
            destino = "ok";
        } else {
            destino = "ok";
        }
        return destino;
    } 
    
    public void buscarPorCuil(){
        if(!(cliente.getCuilCuit()).equals("") && (cliente.getCuilCuit()) != null){
            // Busca todos los CUIL de los clientes
            cliente = gestorUsuario.buscarPorCuil(cliente.getCuilCuit());
            // Busca el cliente de acuerdo al CUIL
            clienteCredito = gestorUsuario.buscarAyN(cliente.getCuilCuit());
        }
    }        

    // CONDICIONES PARA QUE UN CLIENTE SE PUEDA ELIMINAR: TIENE CREDITO PENDIENTE
    public boolean isEliminable() {
        return true;
    }
    
    // VERIFICA SI EL CUIL YA EXISTE (CLIENTE EXISTENTE)
    public boolean usuarioExiste(){
        return true;
    }
    
    public void nuevoCreditoId(){
        
    }
}
