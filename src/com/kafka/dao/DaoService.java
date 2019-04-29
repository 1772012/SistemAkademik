package com.kafka.dao;

import java.util.List;

/**
 *
 * @author Kafka Febianto Agiharta
 * @param <T>
 */
interface DaoService<T> {

    int addData(T object);

    int updateData(T object);

    int removeData(T object);

    List<T> getAllData();
}
