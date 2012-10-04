package dao;

import entidades.TipoCredito;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TipoCreditoFacadeLocal {

    void create(TipoCredito tipocredito);

    void edit(TipoCredito tipocredito);

    void remove(TipoCredito tipocredito);

    TipoCredito find(Object id);

    List<TipoCredito> findAll();

    List<TipoCredito> findRange(int[] range);

    int count();
}
