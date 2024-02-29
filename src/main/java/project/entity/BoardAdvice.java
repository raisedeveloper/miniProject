package project.entity;

import java.time.LocalDate;

public class BoardAdvice {  	// 경매 게시판
	private int bid; 			// 글 번호
	private String uname; 		// 작성자
	private String uid;			// uid
	private String title; 		// 제목
	private String content; 	// 내용
	private LocalDate modTime; 	// 작성일
	private int isDeleted;		// 삭제 여부
	private int viewCount; 		// 조회수
	private int replyCount; 	// 댓글 개수
	
	public BoardAdvice() {}
	
	public BoardAdvice(int bid, String uname, String uid, String title, String content, LocalDate modTime,
			int isDeleted, int viewCount, int replyCount) {
		super();
		this.bid = bid;
		this.uname = uname;
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.modTime = modTime;
		this.isDeleted = isDeleted;
		this.viewCount = viewCount;
		this.replyCount = replyCount;
	}
	
	

	public BoardAdvice(int bid, String uname, String uid, String title, String content, LocalDate modTime,
			int isDeleted, int viewCount) {
		super();
		this.bid = bid;
		this.uname = uname;
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.modTime = modTime;
		this.isDeleted = isDeleted;
		this.viewCount = viewCount;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getModTime() {
		return modTime;
	}

	public void setModTime(LocalDate modTime) {
		this.modTime = modTime;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	@Override
	public String toString() {
		return "BoardAdvice [bid=" + bid + ", uname=" + uname + ", uid=" + uid + ", title=" + title + ", content="
				+ content + ", modTime=" + modTime + ", isDeleted=" + isDeleted + ", viewCount=" + viewCount
				+ ", replyCount=" + replyCount + "]";
	}
	
	

	

}
