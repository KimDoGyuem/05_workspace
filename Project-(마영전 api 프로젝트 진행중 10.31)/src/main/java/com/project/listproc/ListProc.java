package com.project.listproc;

import java.util.ArrayList;

import com.project.dto.GetListDto;
import com.project.dto.GuestDto;
import com.project.mapper.GuestMapper;

import lombok.Data;

@Data
public class ListProc {
	private GuestMapper mapper;
	String word = "";
	public ArrayList<GuestDto> posts;
	
	final int LISTCOUNTPERPAGE = 5; //리스트 표시 글 수
	final int PAGESPERBLOCK = 3;    //블럭 표시 페이지 수
	int totalPage = 0;
	int currentPage = 0;
	int totalBlock = 0;
	int currentBlockNo = 0;
	int blockStartNo = 0;
	int blockEndNo = 0;
	int prevPage = 0;
	int nextPage = 0;
	boolean hasPrev = true;
	boolean hasNext = true;
	
	public void getList() {
		int startIndex = (currentPage-1)*LISTCOUNTPERPAGE;
		GetListDto gl = new GetListDto(startIndex,LISTCOUNTPERPAGE);
		posts = mapper.getList(gl);
	}
	public int getPageCount() {
		int totalPageCount = 0;
		int count = mapper.getPostCount();
		if(count%LISTCOUNTPERPAGE==0) {
			totalPageCount = count/LISTCOUNTPERPAGE;
		}else {
			totalPageCount = count/LISTCOUNTPERPAGE+1;
		}
		return totalPageCount;
	}
	
	public void getSearchList(String word) {
		int startIndex = (currentPage-1)*LISTCOUNTPERPAGE;
		GetListDto gl = new GetListDto(word,startIndex,LISTCOUNTPERPAGE);
		posts = mapper.getSearchList(gl);
	}
	public int getSearchPageCount(String word) {
		int totalPageCount = 0;
		int count = mapper.getSearchPostCount(word);
		if(count%LISTCOUNTPERPAGE==0) {
			totalPageCount = count/LISTCOUNTPERPAGE;
		}else {
			totalPageCount = count/LISTCOUNTPERPAGE+1;
		}
		return totalPageCount;
	}
	
	
	public ListProc(GuestMapper mapper,String word, int currentPage) {
		super();
		this.mapper = mapper;
		this.word = word;
		this.currentPage = currentPage;
		if(word==null||word.equals("null")) {
			totalPage = getPageCount();
			getList();
			this.word = "";
		}else {
			totalPage = getSearchPageCount(word);
			getSearchList(word);
		}
		
		totalBlock = (int)Math.ceil((double)totalPage/PAGESPERBLOCK);
		currentBlockNo = (int)Math.ceil((double)this.currentPage/PAGESPERBLOCK);
		blockStartNo = (currentBlockNo-1)*PAGESPERBLOCK+1;
		blockEndNo = currentBlockNo*PAGESPERBLOCK;
		if(blockEndNo>totalPage) {
			blockEndNo = totalPage;
		}
		if(currentBlockNo==1) {
			hasPrev = false;
		}else {
			hasPrev = true;
			prevPage = (currentBlockNo-1)*PAGESPERBLOCK;
		}
		if(currentBlockNo<totalBlock) {
			hasNext = true;
			nextPage = currentBlockNo*PAGESPERBLOCK+1;
		}else {
			hasNext = false;
		}
	}
	
}
