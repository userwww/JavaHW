package dao;

import entity.Track;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.Collections;
import java.util.List;

public class TrackDao {
    public Track trackById(int id) {
        Transaction transaction = null;
        Track track = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "FROM Track t WHERE t.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            List results = query.getResultList();

            if (results != null && !results.isEmpty()) {
                track = (Track) results.get(0);
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return track;
    }

    public void butchCreate(int quantity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            for (int i = 0; i < quantity; i++) {
                Track t = new Track("Track #" + (i + 1));
                session.save(t);

                if (i % 20 == 0) {
                    session.flush();
                    session.clear();
                }
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void createTrack(Track track) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(track);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Track> listAll() {
        Transaction transaction = null;
        List<Track> results = Collections.emptyList();
        ;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "FROM Track";
            Query<Track> query = session.createQuery(hql);
            results = query.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return results;
    }
}