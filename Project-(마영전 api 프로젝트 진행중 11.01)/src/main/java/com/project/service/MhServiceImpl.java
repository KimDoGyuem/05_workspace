package com.project.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import com.nexon.mh.dto.CharacterBasicDto;
import com.nexon.mh.dto.CharacterBasicInfo;
import com.nexon.mh.dto.CharacterGuildDto;
import com.nexon.mh.dto.CharacterGuildInfo;
import com.nexon.mh.dto.CharacterStatDto;
import com.nexon.mh.dto.CharacterStatInfo;
import com.nexon.mh.dto.MhNameDto;
import com.nexon.mh.dto.MhRankingDto;
import com.nexon.mh.dto.MhRankingInfo;
import com.nexon.mh.dto.RankingInfo;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MhServiceImpl implements MhService{
	private final String API_KEY = "test_6cef866ab2c35ada7007397305e74d6f035f8cd449a2e8b3b9cdb6909e5d9febefe8d04e6d233bd35cf2fabdeb93fb0d";

	public String nameSearch(String name) {
		
		String encodedName = "";
        try {
            encodedName = URLEncoder.encode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("Encoding error: " + e.getMessage());
        }

		String API_URL = "https://open.api.nexon.com/heroes/v2/id?character_name="+encodedName;
		
		RestTemplate restTemplate = new RestTemplate();
		URI uri = null;
		
		try {
			uri = new URI(API_URL);
		}catch(URISyntaxException e) {
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("accept", "application/json");
		headers.set("x-nxopen-api-key", API_KEY);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
//		NhNameDto nh = restTemplate.exchange(uri, HttpMethod.GET, entity, NhNameDto.class).getBody(); //바로 body 메서드를 꺼내오는 방식
		
		String ocid="";
		try {
			ResponseEntity<MhNameDto> response = restTemplate.exchange(uri, HttpMethod.GET, entity, MhNameDto.class);
			MhNameDto nh = response.getBody();
			if(nh != null && nh.ocid != null) {
				ocid = nh.ocid;
			}
		}catch(Exception e) {
			e.printStackTrace();
			ocid = "x";
		}
		
		return ocid;
	}
	
	public void characterBasic(String ocid, Model model) {
		
		String API_URL = "https://open.api.nexon.com/heroes/v2/character/basic?ocid="+ocid;
		System.out.println("로그확인===="+API_URL);
		RestTemplate restTemplate = new RestTemplate();
		URI uri = null;
		CharacterBasicInfo cbInfo = new CharacterBasicInfo();
		
		try {
			uri = new URI(API_URL);
		}catch(URISyntaxException e){
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("accept", "application/json");
		headers.set("x-nxopen-api-key", API_KEY);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		
		try {
			CharacterBasicDto cb = restTemplate.exchange(uri, HttpMethod.GET, entity, CharacterBasicDto.class).getBody();
			if(cb == null) {
				System.out.println("==cb가null임==");
			}else {
				cbInfo.setChaName(cb.character_name);
				cbInfo.setChaDateCreate(cb.character_date_create);
				cbInfo.setChaClassName(cb.character_class_name);
				cbInfo.setChaLevel(cb.character_level);
				cbInfo.setChaCairdeName(cb.cairde_name);
				cbInfo.setChaTitleCount(cb.title_count);
				cbInfo.setChaDressPoint(cb.dress_point.total_point);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("======2");
		}

		model.addAttribute("cbInfo", cbInfo);
	}
	
	public void characterStat(String ocid, Model model) {

		String API_URL = "https://open.api.nexon.com/heroes/v2/character/stat?ocid="+ocid;
		RestTemplate restTemplate = new RestTemplate();
		URI uri = null;
		CharacterStatInfo csInfo = new CharacterStatInfo();
		
		try {
			uri = new URI(API_URL);
		}catch(URISyntaxException e) {
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("accept", "application/json");
		headers.set("x-nxopen-api-key", API_KEY);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		try {
			CharacterStatDto cs = restTemplate.exchange(uri, HttpMethod.GET, entity, CharacterStatDto.class).getBody();
			if(cs == null) {
				System.out.println("==cs가null임==");
			}else {
				csInfo.setOffensive_power(cs.stat.get(0).stat_value);
				csInfo.setMagic_power(cs.stat.get(1).stat_value);
				csInfo.setDefensive_power(cs.stat.get(2).stat_value);
				csInfo.setLuck(cs.stat.get(7).stat_value);
				csInfo.setMax_hp(cs.stat.get(8).stat_value);
				csInfo.setStamina(cs.stat.get(9).stat_value);
				csInfo.setAttack_speed(cs.stat.get(10).stat_value);
				csInfo.setAdditional_damage(cs.stat.get(11).stat_value);
				csInfo.setCritical(cs.stat.get(12).stat_value);
				csInfo.setCritical_Damage(cs.stat.get(13).stat_value);
				csInfo.setCritical_Resistance(cs.stat.get(14).stat_value);
				csInfo.setBalance(cs.stat.get(15).stat_value);
				csInfo.setUnrestricting_Attacks(cs.stat.get(16).stat_value);
				csInfo.setOpposing_power(cs.stat.get(17).stat_value);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("csInfo",csInfo);
	}

	public void characterGuild(String ocid, Model model) {
		
		String API_URL = "https://open.api.nexon.com/heroes/v2/character/guild?ocid="+ocid;
		RestTemplate restTemplate = new RestTemplate();
		URI uri = null;
		CharacterGuildInfo cgInfo = new CharacterGuildInfo();
		
		try {
			uri = new URI(API_URL);
		}catch(URISyntaxException e){
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("accept", "application/json");
		headers.set("x-nxopen-api-key", API_KEY);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		try {
			CharacterGuildDto cg = restTemplate.exchange(uri, HttpMethod.GET, entity, CharacterGuildDto.class).getBody();
			if(cg == null) {
				System.out.println("==cg가null임==");
			}else {
				cgInfo.setGuildName(cg.guild_name);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("======2");
		}

		model.addAttribute("cgInfo", cgInfo);
	}
	
	public void mhRanking(String type, Model model) {
		
		String API_URL = "https://open.api.nexon.com/heroes/v2/ranking/hall-of-honor?ranking_type="+type;
		RestTemplate restTemplate = new RestTemplate();
		URI uri = null;
		
		MhRankingInfo mrInfo = new MhRankingInfo();
		RankingInfo rInfo = null;
		
		try {
			uri = new URI(API_URL);
		}catch(URISyntaxException e) {
			e.printStackTrace();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("accept", "application/json");
		headers.set("x-nxopen-api-key", API_KEY);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		try {
			MhRankingDto mr = restTemplate.exchange(uri, HttpMethod.GET, entity, MhRankingDto.class).getBody();
			if(mr == null) {
				System.out.println("==mr이null임==");
			}else {
				for(int i=0; i<mr.ranking.size(); i++) {
					rInfo = new RankingInfo(mr.ranking.get(i).ranking, mr.ranking.get(i).character_name, mr.ranking.get(i).score);
					mrInfo.getMhRanking().add(rInfo);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("mrInfo",mrInfo);
	}
	
}
