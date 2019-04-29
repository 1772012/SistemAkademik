package com.kafka.dao;

import com.kafka.entity.Jabatan;
import com.kafka.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Kafka 1772012
 */
public class JabatanDaoImpl implements DaoService<Jabatan> {

    @Override
    public int addData(Jabatan object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(Jabatan object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int removeData(Jabatan object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Jabatan> getAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Jabatan.class);
        List<Jabatan> jabatans = criteria.list();
        session.close();
        return jabatans;
    }

}
