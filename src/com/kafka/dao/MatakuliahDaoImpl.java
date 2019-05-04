package com.kafka.dao;

import com.kafka.entity.Matakuliah;
import com.kafka.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Kafka Febianto Agiharta (1772012)
 */
public class MatakuliahDaoImpl implements DaoService<Matakuliah> {

    @Override
    public int addData(Matakuliah object) {
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
    public int updateData(Matakuliah object) {
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
    public int removeData(Matakuliah object) {
        int result = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(object);
            transaction.commit();
            result = 1;
        } catch (Exception e) {
            transaction.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public List<Matakuliah> getAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Matakuliah.class).
                setFetchMode("kurikulum", FetchMode.JOIN);
        List<Matakuliah> matakuliahs = criteria.list();
        session.close();
        return matakuliahs;
    }

}
