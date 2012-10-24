package dao;

import entidades.Solicitud;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CreditoFacadeLocal {

    void create(Solicitud Solicitud);

    void edit(Solicitud Solicitud);

    void remove(Solicitud Solicitud);

    Solicitud find(Object id);

    List<Solicitud> findAll();

    List<Solicitud> findRange(int[] range);

    int count();
}
