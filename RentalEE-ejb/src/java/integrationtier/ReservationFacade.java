/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrationtier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import subbusinesstier.entities.Reservation;

/**
 *
 * @author User
 */
@Stateless
public class ReservationFacade extends AbstractFacade<Reservation> {

    @PersistenceContext(unitName = "RentalEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReservationFacade() {
        super(Reservation.class);
    }
    
}