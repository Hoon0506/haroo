package com.haroo.mapper;

import java.util.List;

import com.haroo.domain.BoardVO;

public interface BoardMapper {
	int insertBoard(BoardVO board);
	List<BoardVO> listBoard();
	BoardVO detailBoard(int bdNo);
}
