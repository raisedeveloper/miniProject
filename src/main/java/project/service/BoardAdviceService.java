package project.service;

import java.util.List;

import project.entity.BoardAdvice;


public interface BoardAdviceService {
	public static final int COUNT_PER_PAGE = 10;

	List<BoardAdvice> getBoardAdviceList(int page, String field, String query);
	
	BoardAdvice getBoardAdvice(int bid);
	
	int getBoardAdviceCount(String field, String query);
	
	void insertBoardAdvice(BoardAdvice boardAd);
	
	void updateBoardAdvice(BoardAdvice boardAd);
	
	void deleteBoardAdvice(int bid);
	
	void increaseViewCount(int bid);
	
	void increaseReplyCount(int bid);
	
}