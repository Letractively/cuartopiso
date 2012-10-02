import org.hibernate.*;
import org.hibernate.cfg.*;

/*******************************************************************************
 * Class ConfHibernate:                                                        *
 * Descripción: Esta se trata del sessionFactory. Gracias a esta clase vamos   *
 * a asegurar que solo hay una única instancia de session mediante el patrón   *
 * de diseño singleton.                                                        *
 * ****************************************************************************/
public class ConfHibernate {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Creamos la Sesión para hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Aviso de fallo al crear la sesión
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
