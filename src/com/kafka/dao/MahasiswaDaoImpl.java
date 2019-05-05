package com.kafka.dao;

import com.kafka.entity.Mahasiswa;
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
public class MahasiswaDaoImpl implements DaoService<Mahasiswa> {

    @Override
    public int addData(Mahasiswa object) {
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
    public int updateData(Mahasiswa object) {
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
    public int removeData(Mahasiswa object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mahasiswa> getAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Mahasiswa.class).
                setFetchMode("dosen", FetchMode.JOIN).setFetchMode("jurusan",
                FetchMode.JOIN);
        List<Mahasiswa> mahasiswas = criteria.list();
        session.close();
        return mahasiswas;
    }

}
