package ComputerManagementFunctionFactory;

import model.Computers;
import model.Supplier;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SupplierFactory {
    Session session = HibernateUtils.getSessionFactory().openSession();
    private ArrayList<Computers> computers;

    public SupplierFactory(Session session) {
        this.session = session;
    }

    public SupplierFactory() {
    }

    public String findAllSuppliers() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Suppliers: ");
        session.createQuery("from Supplier ").getResultList().forEach(System.out::println);
        return null;
    }

    public List<Supplier> findAllSuppliersList() {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Suppliers: ");
        Query query = session.createQuery("from Supplier ");

        List<Supplier> suppliers = query.getResultList();
        session.close();
        return suppliers;

    }

    public Supplier findSupplierByName(String supplierCompanyName) {

        Query query = session.createQuery("select b from Supplier b where b.supplierCompanyName=:supplierCompanyName");
        query.setParameter("supplierCompanyName", supplierCompanyName);
        List<Supplier> suppliers = query.getResultList();

        Supplier supplier = null;

        if (!suppliers.isEmpty()) {
            return suppliers.get(0);
        }
        session.close();
        return supplier;
    }

    public Supplier findProductByName(String product) {

        Query query = session.createQuery("select b from Supplier b where b.product=:product");
        query.setParameter("product", product);
        List<Supplier> suppliers = query.getResultList();

        Supplier supplier = null;

        if (!suppliers.isEmpty()) {
            return suppliers.get(0);
        }
        session.close();
        return supplier;
    }


    public void createSuppliers(final Supplier supplier) {

        Transaction transaction = session.beginTransaction();

        session.save(supplier);

        transaction.commit();

    }

    public boolean createSupplierSection(String supplierCompanyName, String product, Integer quantity, Integer price, LocalDateTime createdOn) {

        // the data are okay
        // create the user
        Supplier supplier = new Supplier(supplierCompanyName, product, quantity, price, createdOn);
        //this.computers.add(computers);
        createSuppliers(supplier);
        return true;

    }


    public void editSuppliers(Supplier updatedSuppliers) {

        session = HibernateUtils.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.update(updatedSuppliers);

        transaction.commit();

    }

    public Supplier findSupplierByID(int Id) {
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_--_-_-_-_-");
        System.out.println("Print All From Supplier by id: ");
        return session.find(Supplier.class, Id);
    }

    public int countCost() {

        Query query = session.createQuery("select sum(c.price) from Supplier c");
        Integer cartels = Math.toIntExact((Long) query.getSingleResult());

        return cartels;

    }

    public int getLastID() {

        Query query = session.createQuery("select max(supplierID) from Supplier ");
        Integer suppliers = Math.toIntExact((Integer) query.getSingleResult());

        return suppliers;

    }

    public int getFirstID() {

        Query query = session.createQuery("select min(supplierID) from Supplier ");
        Integer employeeID = Math.toIntExact((Integer) query.getSingleResult());

        return employeeID;

    }

}
