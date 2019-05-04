package com.kafka.dao;

import com.kafka.entity.Kurikulum;
import com.kafka.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Kafka 1772012
 */
public class KurikulumDaoImpl implements DaoService<Kurikulum> {

    @Override
    public int addData(Kurikulum object) {
        int result = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(object);
            transaction.commit();
            result = 1;
        } catch (Exception e) {
            transaction.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public int updateData(Kurikulum object) {
        int result = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(object);
            transaction.commit();
            result = 1;
        } catch (Exception e) {
            transaction.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public int removeData(Kurikulum object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Kurikulum> getAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Kurikulum.class);
        List<Kurikulum> kurikulums = criteria.list();
        session.close();
        return kurikulums;
    }

}
