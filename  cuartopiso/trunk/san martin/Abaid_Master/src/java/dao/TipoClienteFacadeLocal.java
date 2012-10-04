package dao;

import entidades.TipoCliente;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TipoClienteFacadeLocal {

    void create(TipoCliente tipocliente);

    void edit(TipoCliente tipocliente);

    void remove(TipoCliente tipocliente);

    TipoCliente find(Object id);

    List<TipoCliente> findAll();

    List<TipoCliente> findRange(int[] range);

    int count();
}
