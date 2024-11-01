package com.nexon.mh.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class MhRankingInfo {
	private List<RankingInfo> mhRanking = new ArrayList<RankingInfo>();
}
