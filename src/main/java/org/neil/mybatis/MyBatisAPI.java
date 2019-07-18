package org.neil.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.neil.dao.PCDao;

/**
 * @author neil
 * @date 2019-07-05
 */
public class MyBatisAPI{

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            PCDao pcDao = sqlSession.getMapper(PCDao.class);
            String maxId = pcDao.getMAXId();
            System.out.println(maxId);
        }finally {
            sqlSession.close();
        }


    }
}
