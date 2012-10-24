package control;

import entidades.Cliente;
import entidades.Distrito;
import entidades.Domicilio;
import entidades.EstadoCivil;
import entidades.Localidad;
import entidades.Profesion;
import entidades.Usuario;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import negocio.GestorUsuarioLocal;

@ManagedBean(name = "usuarioControl")
@SessionScoped
public class UsuarioControl implements Serializable{

    private Usuario usuario;
    private Cliente cliente;
    private String apellido;
    private String nombre;
    private String cuil;
    private String estadoCivil;
    private String telefono;
    private String celular;
//    private String profesion;
    private Double sueldo;
    private String calle;
    private short piso;
    private short nro;
    private String dpto;
    private String email;
    private Domicilio domicilio;
    private Distrito distrito;
    private Profesion profesion;
    private Localidad localidad;
//    private EstadoCivil estadoCivil;
    private String login = "";
    private String password = "";
    private String password2 = "";
    private Date fechaNacimiento;
    private String fechaNace;
    private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
    @EJB
    private GestorUsuarioLocal gestorUsuario;

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

//    public String getProfesion() {
//        return profesion;
//    }
//
//    public void setProfesion(String profesion) {
//        this.profesion = profesion;
//    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public short getPiso() {
        return piso;
    }

    public void setPiso(short piso) {
        this.piso = piso;
    }

    public short getNro() {
        return nro;
    }

    public void setNro(short nro) {
        this.nro = nro;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getFechaNace() {
        return fechaNace;
    }

    public void setFechaNace(String fechaNace) {
        this.fechaNace = fechaNace;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
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

    public String crearCliente() {
        crearDomicilio();               
        cliente = new Cliente();
        cliente.setApellido(apellido);
        cliente.setNombre(nombre);
        cliente.setCuilCuit(cuil);
        cliente.setEmail(email);
        cliente.setEstadoCivil(estadoCivil);
        cliente.setFechaNacimiento(fechaNace);
        cliente.setSueldo(sueldo);
        cliente.setDomicilioId(domicilio);
        cliente.setProfesionId(getProfesion());
        gestorUsuario.registrarCliente(cliente);
        return "exito.cliente";
    }

    public void crearDomicilio(){
        domicilio = new Domicilio();
        domicilio.setCalle(calle);
        domicilio.setDpto(dpto);
        domicilio.setNumero(nro);
        domicilio.setPiso(piso);
        domicilio.setDistritoId(distrito);
        
        
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
        profesion = new Profesion();
        domicilio = new Domicilio();
        localidad = new Localidad();
        distrito = new Distrito();
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
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
}
