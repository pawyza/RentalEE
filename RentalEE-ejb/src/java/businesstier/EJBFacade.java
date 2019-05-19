/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesstier;

import integrationtier.ClientFacade;
import integrationtier.RecordFacade;
import integrationtier.RentalFacade;
import integrationtier.ReservationFacade;
import integrationtier.TitleRecordFacade;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import subbusinesstier.Facade;


      
/**
 *
 * @author User
 */
@Stateless
public class EJBFacade implements EJBFacadeRemote {

    @EJB
    private ClientFacade clientFacade;

    @EJB
    private RecordFacade recordFacade;

    @EJB
    private RentalFacade rentalFacade;

    @EJB
    private ReservationFacade reservationFacade;

    @EJB
    private TitleRecordFacade titleRecordFacade;
    
    
    Facade facade = new Facade();
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void deleteClient(int number) {
        facade.deleteClient(number);
    }

    @Override
    public void deleteTitleRecord(String id) {
        facade.deleteTitleRecord(id);
    }

    @Override
    public void deleteReservation(int number) {
        facade.deleteReservation(number);
    }

    @Override
    public void deleteRecord(int number) {
        facade.deleteRecord(number);
    }
    
    @Override
    public String addTitleRecord(String[] data) {
        return facade.addTitleRecord(data);
    }


    @Override
    public String[] transformTittleRecordToString(int index) {
        return facade.transformTittleRecordToString(index);
    }

    @Override
    public ArrayList<String> addRecord(String[] data1, String[] data2) {
        return facade.addRecord(data1, data2);
    }
    
    @Override
    public String addClient(String data[]) {
        return facade.addClient(data);
    }

    @Override
    public String addReservation(String[] data1, String[] data2, int number, LocalDate dateStart, LocalDate dateEnd) {
        return facade.addReservation(data1, data2, number, dateStart, dateEnd);
    }
    
    @Override
    public int transformClientIndexToNumber(int index){
        return facade.transformClientIndexToNumber(index);
    }
       
    @Override
    public String transformTitleRecordIndexToString(int index){
        return facade.transformTitleRecordIndexToString(index);
    }

    @Override
    public List<String> getTitleRecordsModelString() {
        return facade.getTitleRecordsModelString();
    }

    @Override
    public List<String> getClientsModelString() {
        return facade.getClientsModelString();
    }

    @Override
    public List<String> getRecordsModelString() {
        return facade.getRecordsModelString();
    }
    
    @Override
    public List<String> getReservationModelString() {
        return facade.getReservationModelString();
    }
    
    @Override
    public int transformReservationIndexToNumber(int index) {
        return facade.transformReservationIndexToNumber(index);
    }

    @Override
    public List<String[]> getTitleRecordStrings() {
        return facade.getTitleRecordStrings();
    }

    @Override
    public List<String[]> getRecordStrings() {
        return facade.getRecordStrings();
    }

    @Override
    public List<String[]> getReservationStrings() {
        return facade.getReservationStrings();
    }

    @Override
    public List<String[]> getClientStrings() {
        return facade.getClientStrings();
    }
}
