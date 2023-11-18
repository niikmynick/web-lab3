package com.example.weblab3.dbUtils;

import com.example.weblab3.beans.AreaCheckerBean;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class CheckAreaDAOImpl implements CheckAreaDAO {
    @Override
    public void addNewResult(AreaCheckerBean result) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtils.getFactory().openSession();
            session.beginTransaction();
            session.persist(result);
            session.getTransaction().commit();
        } catch (Throwable e) {
            System.err.println("DAO error occurred: " + e);
            throw new SQLException(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateResult(Long bus_id, AreaCheckerBean result) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtils.getFactory().openSession();
            session.beginTransaction();
            session.merge(result);
            session.getTransaction().commit();
        } catch (Throwable e) {
            System.err.println("DAO error occurred: " + e);
            throw new SQLException(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public AreaCheckerBean getResultById(Long result_id) throws SQLException {
        Session session = null;
        AreaCheckerBean result;
        try {
            session = HibernateUtils.getFactory().openSession();
            result = session.getReference(AreaCheckerBean.class, result_id);
        } catch (Throwable e) {
            System.err.println("DAO error occurred: " + e);
            throw new SQLException(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public Collection<AreaCheckerBean> getAllResults() throws SQLException {
        Session session = null;
        List<AreaCheckerBean> results;
        try {
            session = HibernateUtils.getFactory().openSession();
            var criteriaQuery = session.getCriteriaBuilder().createQuery(AreaCheckerBean.class);
            Root<AreaCheckerBean> root = criteriaQuery.from(AreaCheckerBean.class);
            results = session.createQuery(criteriaQuery.select(root)).getResultList();
        } catch (Throwable e) {
            System.err.println("DAO error occurred: " + e);
            throw new SQLException(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return results;
    }

    @Override
    public void deleteResult(AreaCheckerBean result) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtils.getFactory().openSession();
            session.beginTransaction();
            session.remove(result);
            session.getTransaction().commit();
        } catch (Throwable e) {
            System.err.println("DAO error occurred: " + e);
            throw new SQLException(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public final String TABLE_NAME = "results";
    @Override
    public void clearResults() throws SQLException {
        Session session = null;
        try {
            session = HibernateUtils.getFactory().openSession();
            session.beginTransaction();
            String sql = "delete from " + TABLE_NAME;
            session.createNativeQuery(sql, this.getClass()).executeUpdate();
            session.getTransaction().commit();
        } catch (Throwable e) {
            System.err.println("DAO error occurred: " + e);
            throw new SQLException(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}