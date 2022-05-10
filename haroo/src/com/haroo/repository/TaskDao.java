package com.haroo.repository;

import com.haroo.domain.EmployeeVO;
import com.haroo.domain.TaskVO;
import com.haroo.mapper.EmployeeMapper;
import com.haroo.mapper.TaskMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class TaskDao {

    private static TaskDao taskDao = new TaskDao();

    public static TaskDao getInstance() {
        return taskDao;
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

    //기존 일정 가져오기
    public List<TaskVO> getTaskList(int em_no) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();

        List<TaskVO> taskVOList = null;

        try {
            taskVOList = sqlSession.selectList("haroo.mapper.TaskMapper.getTaskList", em_no);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }

        return taskVOList;
    }

    //일정 추가
    public int insertTask(TaskVO taskVO) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int result = 0;

        System.out.println(taskVO.toString());
        try {
            result = sqlSession.getMapper(TaskMapper.class).insertTask(taskVO);
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
