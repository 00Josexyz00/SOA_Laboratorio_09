
package com.restful.session;

import com.restful.entidades.Personal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonalFacade extends AbstractFacade<Personal> {

    @PersistenceContext(unitName = "com.mycompany_WebServicesRestful_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonalFacade() {
        super(Personal.class);
    }
    
}
