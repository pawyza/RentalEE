/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrationtier;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import subbusinesstier.entities.Client;
import subbusinesstier.entities.Reservation;
import subbusinesstier.entities.TitleRecord;

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
    
    public void addReservations(List<Client> clients){
        for (Client client:clients){
            if (client.getId() ==null){
                continue;
            } 
            for (Reservation reservation:client.getReservations()){
                if (reservation.getId() == null)
                    getEntityManager().persist(reservation);
            }
        }
    }
}
