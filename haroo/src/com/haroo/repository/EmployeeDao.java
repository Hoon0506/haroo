package com.haroo.repository;
<<<<<<< HEAD:haroo/src/com/haroo/repository/EmployeeDao.java

import com.haroo.domain.EmployeeVO;
import com.haroo.mapper.EmployeeMapper;
=======
>>>>>>> cc8be617ba2be86f7e24b1a8a45710aa8b502c6a:haroo/src/haroo/repository/EmployeeDao.java

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.haroo.domain.EmployeeVO;
import com.haroo.mapper.EmployeeMapper;

import java.io.InputStream;

public class EmployeeDao {

    private static EmployeeDao employeeDao = new EmployeeDao();

    public static EmployeeDao getInstance() {
        return employeeDao;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    //?‚¬?› ê°?? ¸?˜¤ê¸?
    public EmployeeVO loginEmployee(EmployeeVO employeeVO) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();

        EmployeeVO finalEmployeeVO = null;

        try {
            finalEmployeeVO = sqlSession.getMapper(EmployeeMapper.class).loginEmployee(employeeVO);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }

        return finalEmployeeVO;
    }

    //?‚¬?› ë§ˆì´?Ž˜?´ì§? ?ˆ˜? •
    public int updateEmployee(EmployeeVO employeeVO) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int result = 0;

        try {
            result = sqlSession.getMapper(EmployeeMapper.class).updateEmployee(employeeVO);

            if (result > 0) sqlSession.commit();
            else sqlSession.rollback();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }

        return result;
    }
}
