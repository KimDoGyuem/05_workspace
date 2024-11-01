package com.peisia.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.peisia.dto.WeatherDto;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/weather/*")
@AllArgsConstructor
@Controller
public class WeatherController {
	@RequestMapping("/w")											
	public void w(Model m) {											
		//// 우리나라 공공 api ////										
		//인코딩 인증키										
		String API_KEY = "lgQnrAGM1hjuAQV6admXqXgNs%2FtJKe2bHB1paQWiTvxXiNjjol%2BfU%2BBLuOdIRIDHB1GlFAoXLrmzEkqrn%2Ful8Q%3D%3D";										
		String API_URL = "http://apis.data.go.kr/1360000/AsosDalyInfoService/getWthrDataList?numOfRows=10&pageNo=1&dateCd=DAY&startDt=20241028&endDt=20241029&stnIds=108&dataCd=ASOS&dataType=JSON&serviceKey=" + API_KEY;										
				// * 주의 * https 아님 http 임. https 는 인증관련 복잡한 처리를 해야함.								
		RestTemplate restTemplate = new RestTemplate();										
												
		//// **** 중요 **** uri										
		URI uri = null; //java.net.URI 임포트 하셈										
		try {										
			uri = new URI(API_URL); // URI 클래스는 URL에 대한 유효성 검사, 구성요소 추출, 보안(특수문자, 공백 처리 등)을 도와줌									
		} catch (URISyntaxException e) {										
			e.printStackTrace();									
		}										
												
		String s = restTemplate.getForObject(uri, String.class); //										
		log.info("====== 우리나라 날씨 잘 나오나? "+s);	
		
		WeatherDto kw = restTemplate.getForObject(uri, WeatherDto.class); // 자기 클래스로 바꾸시오..									
		log.info("==== json ==== : 우리나라 날씨 잘 나오냐? : "+kw.response.body.dataType);									
		log.info("==== json ==== : 우리나라 날씨 잘 나오냐? : "+kw.response.body.dataType);									
		String location = kw.response.body.items.item.get(0).stnNm;									
		String tMin = kw.response.body.items.item.get(0).minTa;									
		String tMax = kw.response.body.items.item.get(0).maxTa;									
		String tm = kw.response.body.items.item.get(0).tm;									
		String ddaraa = String.format("==== json ==== : 날짜는 %s 입니다.", tm);									
		String ddara = String.format("==== json ==== : 어제의 날씨입니다~ 어제 %s 의 최저기온은 %s 도 최고 기온은 %s 였습니다. 날씨였습니다.", location, tMin, tMax);									
		log.info(ddaraa);									
		log.info(ddara);
		m.addAttribute("date",ddaraa);
		m.addAttribute("weathertext",ddara);
	}											
												
}
