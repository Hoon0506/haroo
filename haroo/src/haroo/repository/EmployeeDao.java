package haroo.repository;

import haroo.domain.EmployeeVO;
import haroo.mapper.EmployeeMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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

    //사원 가져오기
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

    //사원 마이페이지 수정
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
