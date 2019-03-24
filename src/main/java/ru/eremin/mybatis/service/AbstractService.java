package ru.eremin.mybatis.service;

import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @autor Artem Eremin on 24.03.2019.
 */

abstract class AbstractService {
    private static final String resource = "mybatis-config.xml";

    final SqlSessionFactory sqlSessionFactory;

    final SqlSession sqlSession;

    @SneakyThrows
    AbstractService() {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    public void commit() {
        sqlSession.commit();
    }

    public void rollback() {
        sqlSession.rollback();
    }
}
