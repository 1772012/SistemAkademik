package com.kafka.dao;

import com.kafka.entity.Account;
import com.kafka.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Kafka 1772012
 */
public class AccountDaoImpl implements DaoService<Account> {

    @Override
    public int addData(Account object) {
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
    public int updateData(Account object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int removeData(Account object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Account> getAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Account.class).setFetchMode(
                "jabatan", FetchMode.JOIN);
        List<Account> accounts = criteria.list();
        session.close();
        return accounts;
    }
}
