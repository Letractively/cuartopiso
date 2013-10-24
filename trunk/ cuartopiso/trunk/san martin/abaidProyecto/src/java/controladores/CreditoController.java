package controladores;

import entidades.Credito;
import controladores.util.JsfUtil;
import controladores.util.PaginationHelper;
import dao.ClienteFacade;
import dao.CreditoFacade;
import dao.PlanFacade;
import entidades.Cliente;
import entidades.Plan;
import java.awt.event.ActionEvent;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@ManagedBean(name = "creditoController")
@SessionScoped
public class CreditoController implements Serializable {

    private Credito current;
    private Cliente cliente;
    private DataModel items = null;
    @EJB
    private dao.CreditoFacade ejbFacade;
    @EJB
    private dao.ClienteFacade ejbCliente;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private boolean logged;
    private int dni;
    private DecimalFormatSymbols ptoDecimal = new DecimalFormatSymbols();
    private DecimalFormat dF;
    private int cuotas;
    private float tasa;
    private String[] valorIntereses;
    private String[] valorCapitales;
    private Float[] intereses;
    private Float[] capitales;
    private float montoXcuota;
    private float intXcuota;
    private float importe;
    private Date fechaVto;
    private float interes;
    private float potencia;
    private float fraccion;
    private float importeCuota;
    private String valorCuota;
    private String[] valorCapital;
    private String[] valorInteres;
    private float total;

    public Credito getCurrent() {
        return current;
    }

    public void setCurrent(Credito current) {
        this.current = current;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public DecimalFormatSymbols getPtoDecimal() {
        return ptoDecimal;
    }

    public void setPtoDecimal(DecimalFormatSymbols ptoDecimal) {
        this.ptoDecimal = ptoDecimal;
    }

    public DecimalFormat getdF() {
        return dF;
    }

    public void setdF(DecimalFormat dF) {
        this.dF = dF;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public float getTasa() {
        return tasa;
    }

    public void setTasa(float tasa) {
        this.tasa = tasa;
    }

    public String[] getValorIntereses() {
        return valorIntereses;
    }

    public void setValorIntereses(String[] valorIntereses) {
        this.valorIntereses = valorIntereses;
    }

    public String[] getValorCapitales() {
        return valorCapitales;
    }

    public void setValorCapitales(String[] valorCapitales) {
        this.valorCapitales = valorCapitales;
    }

    public Float[] getIntereses() {
        return intereses;
    }

    public void setIntereses(Float[] intereses) {
        this.intereses = intereses;
    }

    public Float[] getCapitales() {
        return capitales;
    }

    public void setCapitales(Float[] capitales) {
        this.capitales = capitales;
    }

    public float getMontoXcuota() {
        return montoXcuota;
    }

    public void setMontoXcuota(float montoXcuota) {
        this.montoXcuota = montoXcuota;
    }

    public float getIntXcuota() {
        return intXcuota;
    }

    public void setIntXcuota(float intXcuota) {
        this.intXcuota = intXcuota;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public Date getFechaVto() {
        return fechaVto;
    }

    public void setFechaVto(Date fechaVto) {
        this.fechaVto = fechaVto;
    }

    public float getInteres() {
        return interes;
    }

    public void setInteres(float interes) {
        this.interes = interes;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public float getFraccion() {
        return fraccion;
    }

    public void setFraccion(float fraccion) {
        this.fraccion = fraccion;
    }

    public float getImporteCuota() {
        return importeCuota;
    }

    public void setImporteCuota(float importeCuota) {
        this.importeCuota = importeCuota;
    }

    public String getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(String valorCuota) {
        this.valorCuota = valorCuota;
    }

    public String[] getValorCapital() {
        return valorCapital;
    }

    public void setValorCapital(String[] valorCapital) {
        this.valorCapital = valorCapital;
    }

    public String[] getValorInteres() {
        return valorInteres;
    }

    public void setValorInteres(String[] valorInteres) {
        this.valorInteres = valorInteres;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public CreditoController() {
    }

    public Credito getSelected() {
        if (current == null) {
            current = new Credito();
            selectedItemIndex = -1;
        }
        return current;
    }

    private CreditoFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {
                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Credito) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Credito();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CreditoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Credito) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CreditoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Credito) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CreditoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public void buscarXdni() {
        try {

            cliente = ejbCliente.buscarPorDni(cliente.getDni());
            if (current != null) {

                logged = true;
                // registrarAccesoUsuario(current);
            } else {
                logged = false;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "El usuario no es valido", "No puede entrar al sistema"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    e.getMessage(), ""));
        }

    }
/*
    public String createMetodoDirecto() {
        try { //obtengo los datos de la solicitud cargada anteriormente
            tasa = current.getPlanList().get(getTasa());
            importe = current.getCapital();
            cuotas = current.getIdPlan().getCanCuotas();
            fechaVto = current.getFechaCredito();
            cliente = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("CLIENTE");

            //obengo los datos necesarios para calcular el interes
            valorIntereses = new String[cuotas];
            valorCapitales = new String[cuotas];
            intereses = new Float[cuotas];
            capitales = new Float[cuotas];
            montoXcuota = importe / cuotas;
            intXcuota = (importe * tasa) / 100;
            Calendar cal;


            //calculo los montos especificos
            for (int i = 0; i < cuotas; i++) {
                intereses[i] = intXcuota;
                capitales[i] = montoXcuota + intXcuota;

                cal = calculoFechaVto(i);
                fechaVto = cal.getTime();




                //seteo los valores de cada cuota
                current.setCuota(i + 1);
                current.setIdCliente(cliente);

                current.setComprobante(current.getComprobante());
                current.setIntXcuota(intXcuota);
                current.setMontoXcuota(montoXcuota);
                current.setMontoTotal(capitales[i]);


                // guardo los valores en la base de datos
                getFacade().create(current);

                //calculo fecha de vencimiento 2
                cal = calculoFechaVto2(i);
                fechaVto = cal.getTime();

                current.setFechaVto1(fechaVto);
                getFacade().edit(current);
            }
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/anotaciones/comentarios").getString("CreditoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/anotaciones/comentarios").getString("PersistenceErrorOccured"));
            return null;
        }
    }
*/
    private Calendar calculoFechaVto(int contador) {
        Calendar fechaCuota = Calendar.getInstance();
        int dias = contador * 30;
        fechaCuota.add(Calendar.DATE, dias);
        return fechaCuota;
    }

    private Calendar calculoFechaVto2(int contador) {
        Calendar fechaCuota = Calendar.getInstance();
        int dias = contador * 60;
        fechaCuota.add(Calendar.DATE, dias);
        return fechaCuota;
    }
    private int idrProfesion;
    @EJB
    private dao.PlanFacade planFacade;
    private List<Plan> listaPlanes;

    public CreditoFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(CreditoFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public ClienteFacade getEjbCliente() {
        return ejbCliente;
    }

    public void setEjbCliente(ClienteFacade ejbCliente) {
        this.ejbCliente = ejbCliente;
    }

    public int getIdrProfesion() {
        return idrProfesion;
    }

    public void setIdrProfesion(int idrProfesion) {
        this.idrProfesion = idrProfesion;
    }

    public PlanFacade getPlanFacade() {
        return planFacade;
    }

    public void setPlanFacade(PlanFacade planFacade) {
        this.planFacade = planFacade;
    }

    public List<Plan> getListaPlanes() {
        return listaPlanes;
    }

    public void setListaPlanes(List<Plan> listaPlanes) {
        this.listaPlanes = listaPlanes;
    }

    public void cargaListaAnios() {
        cliente = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("CLIENTE");
        

        listaPlanes = planFacade.buscarDistritos(cliente);
     
    }

    @FacesConverter(forClass = Credito.class)
    public static class CreditoControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CreditoController controller = (CreditoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "creditoController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Credito) {
                Credito o = (Credito) object;
                return getStringKey(o.getIdCredito());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Credito.class.getName());
            }
        }
    }
}
