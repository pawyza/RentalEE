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
import subbusinesstier.entities.Record;
import subbusinesstier.entities.TitleRecord;

/**
 *
 * @author User
 */
@Stateless
public class RecordFacade extends AbstractFacade<Record> {

    @PersistenceContext(unitName = "RentalEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecordFacade() {
        super(Record.class);
    }
    
    public void addRecords(List<TitleRecord> titleRecords ){
        for (TitleRecord titleRecord:titleRecords){
            if (titleRecord.getNumber() != null){
                continue;
            } 
            for (Record record:titleRecord.getRecords()){
                if (record.getNumber() != null) getEntityManager().persist(record);
            }
        }
    }
}
