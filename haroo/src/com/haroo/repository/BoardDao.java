package com.haroo.repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.haroo.domain.BoardVO;
import com.haroo.domain.ReplyVO;
import com.haroo.domain.SearchVO;
import com.haroo.mapper.BoardMapper;

public class BoardDao {
	private static BoardDao dao = new BoardDao();

	public static BoardDao getInstance() {
		return dao;
	}

	// sqlsessionfactory를 가져오는 방법
	public SqlSessionFactory getSqlSessionFactory() {
		// mybatis-config.xml => SqlsessionFactory 변환
		String resource = "mybatis-config.xml";
		InputStream in = null;

		try {
			in = Resources.getResourceAsStream(resource); // Resources는 ibatis로
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new SqlSessionFactoryBuilder().build(in);
	}

	// 게시판 글 등록
	public int insertBoard(BoardVO board) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			// re = sqlSession.insert("kosta.mapper.BoardMapper.insertBoard", board); //row의
			// 갯수를 리턴
			re = sqlSession.getMapper(BoardMapper.class).insertBoard(board);
			if (re > 0) { // insert, update, delete때 트랜잭션 처리를 해야한다. spring에서는 말고 여기서
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return re;
	}// end insertBoard

	// 게시판 목록 보기
	public List<BoardVO> listBoard(int startRow, SearchVO search) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<BoardVO> list = null;
		try {
			list = sqlSession.getMapper(BoardMapper.class).listBoard(search, new RowBounds(startRow, 10));// search를 먼저써야한다..!!
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return list;
	}// end listBoard

	public BoardVO detailBoard(int bdNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession(); // 이거는 필수
		BoardVO board = null;
		try {
			board = sqlSession.getMapper(BoardMapper.class).detailBoard(bdNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return board;
	}// end detailBoard

	public int updateBoard(BoardVO board) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			re = sqlSession.getMapper(BoardMapper.class).updateBoard(board);
			if (re > 0) { // insert, update, delete때 트랜잭션 처리를 해야한다. spring에서는 말고 여기서
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return re;
	}// end updateBoard
	
	public int deleteBoard(int bdNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession(); // 이거는 필수
		int re = -1;
		try {
			re = sqlSession.getMapper(BoardMapper.class).deleteBoard(bdNo);
			if (re > 0) { // insert, update, delete때 트랜잭션 처리를 해야한다. spring에서는 말고 여기서
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return re;
	}// enddeleteBoard
	
	public int countBoard(SearchVO search) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;

		try {
			re = sqlSession.getMapper(BoardMapper.class).countBoard(search);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return re;
	}// end countBoard
	
	public int insertReply(ReplyVO reply) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(BoardMapper.class).insertReply(reply);
			if(re>0) { //insert, update, delete때 트랜잭션 처리를 해야한다. spring에서는 말고 여기서
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	}// end insertReply
	public List<ReplyVO> listReply(int bdNo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession(); //이거는 필수
		List<ReplyVO> list = null;
		try {
			list = sqlSession.getMapper(BoardMapper.class).listReply(bdNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return list;
	}// end listReply
}
