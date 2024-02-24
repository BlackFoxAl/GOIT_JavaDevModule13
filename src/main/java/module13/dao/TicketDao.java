package module13.dao;

import module13.model.Ticket;
import module13.service.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TicketDao {
    private final SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    // Create
    public void save(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(ticket);
            tx.commit();
        }
    }

    // Read
    public Ticket findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    // Update
    public void update(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(ticket);
            tx.commit();
        }
    }

    // Delete
    public void delete(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.remove(ticket);
            tx.commit();
        }
    }
}
