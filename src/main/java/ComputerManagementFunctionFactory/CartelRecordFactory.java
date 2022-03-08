package ComputerManagementFunctionFactory;

import model.CartelRecord;
import model.Employee;
import model.Supplier;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CartelRecordFactory {
    Session session = HibernateUtils.getSessionFactory().openSession();

    public CartelRecordFactory() {
    }

    public void createCartelRecord(final CartelRecord cartelRecord) {
        Transaction transaction = session.beginTransaction();

        session.save(cartelRecord);

        transaction.commit();
    }

    public boolean createOfCartelRecord(CartelRecordFactory cartelRecordFactory){
        return true;
    }


    public String findAllCartelRecord() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From CartelRecord: ");
        session.createQuery("from CartelRecord").getResultList().forEach(System.out::println);
        return null;
    }

    public int countSellsFinal(String firstName) {

        Query query = session.createQuery("select count(c.cartelRecordId) from CartelRecord c where c.cartel.employee.firstName=:firstName");
        query.setParameter("firstName", firstName);
        Integer cartels = Math.toIntExact((Long) query.getSingleResult());

        session.close();
        return cartels;

    }

    public void editCartelRecord(CartelRecord updatedCartelRecord) {
        session = HibernateUtils.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.update(updatedCartelRecord);

        transaction.commit();
    }

    public List<CartelRecord> findAllCartelRecordList() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Cartel Record: ");
        Query query = session.createQuery("from CartelRecord ");

        List<CartelRecord> cartelRecords = query.getResultList();
        session.close();
        return cartelRecords;

    }

}
