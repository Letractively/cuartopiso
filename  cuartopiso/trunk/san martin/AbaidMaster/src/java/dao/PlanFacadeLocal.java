
package dao;

import entidades.Plan;
import java.util.List;
import javax.ejb.Local;

@Local
public interface PlanFacadeLocal {

    void create(Plan plan);

    void edit(Plan plan);

    void remove(Plan plan);

    Plan find(Object id);

    List<Plan> findAll();

    List<Plan> findRange(int[] range);

    int count();
    
}
