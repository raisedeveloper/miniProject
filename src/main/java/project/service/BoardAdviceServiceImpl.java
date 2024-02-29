package project.service;

import java.util.List;

import project.dao.BoardAdviceDao;
import project.dao.BoardAuctionDao;

import project.entity.BoardAdvice;

public class BoardAdviceServiceImpl implements BoardAdviceService {
	private BoardAdviceDao baDao = new BoardAdviceDao();

	@Override
	public List<BoardAdvice> getBoardAdviceList(int page, String field, String query) {
		int offset = (page - 1) * COUNT_PER_PAGE;
		query = "%" + query + "%";
		List<BoardAdvice> list = baDao.getBoardAdviceList(field, query, COUNT_PER_PAGE, offset);
		return null;
	}
	// bid를 넣어서 BoardAdvice가져옴
	@Override
	public BoardAdvice getBoardAdvice(int bid) {
		return  baDao.getBoardAdvice(bid); 
	}
	
	// 보드 숫자 카운트
	@Override
	public int getBoardAdviceCount(String field, String query) {
		return  baDao.getBoardAdviceCount(field, query); 
	}
	
	// BoardAdvice 삽입
	@Override
	public void insertBoardAdvice(BoardAdvice boardAd) {
		baDao.insertBoardAdvice(boardAd);
		
	}
	
	// BoardAdvice 수정
	@Override
	public void updateBoardAdvice(BoardAdvice boardAd) {
		baDao.updateBoardAdvice(boardAd); 
		
	}

	@Override
	public void deleteBoardAdvice(int bid) {
		baDao.deleteBoardAdvice(bid); 
		
	}

	@Override
	public void increaseViewCount(int bid) {
		baDao.increaseCount("view",bid); 
		
	}

	@Override
	public void increaseReplyCount(int bid) {
		baDao.increaseCount("reply", bid); 
		
	}  
	


}