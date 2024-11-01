package com.project.dto;

import lombok.Data;

@Data
public class GetListDto {
	private String word;
	private int offset = 0;		//limit index 시작 
	private int rowCount = 0;	//끝 
	
	public GetListDto(int offset, int rowCount) {
		super();
		this.offset = offset;
		this.rowCount = rowCount;
	}
	
	public GetListDto(String word, int offset, int rowCount) {
		super();
		this.word = word;
		this.offset = offset;
		this.rowCount = rowCount;
	}
	
}
