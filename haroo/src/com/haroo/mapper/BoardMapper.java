package com.haroo.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.haroo.domain.BoardVO;
import com.haroo.domain.ReplyVO;
import com.haroo.domain.SearchVO;

public interface BoardMapper {
	int insertBoard(BoardVO board);
	List<BoardVO> listBoard(SearchVO search);
	BoardVO detailBoard(int bdNo);
	int updateBoard(BoardVO board);
	int deleteBoard(int bdNo);
	int countBoard(SearchVO search);
	int insertReply(ReplyVO reply);
	List<ReplyVO> listReply(int bdNo);
}
