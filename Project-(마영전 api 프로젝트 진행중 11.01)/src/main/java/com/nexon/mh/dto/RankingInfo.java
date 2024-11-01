package com.nexon.mh.dto;

import lombok.Data;

@Data
public class RankingInfo {
	private int ranking;
	private String name;
	private int score;
	
	public RankingInfo(int ranking, String name, int score) {
		super();
		this.ranking = ranking;
		this.name = name;
		this.score = score;
	}
	
}
