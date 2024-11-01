package com.project.service;

import org.springframework.stereotype.Service;

import com.project.dto.AccountDto;
import com.project.dto.GuestDto;
import com.project.listproc.ListProc;
import com.project.mapper.GuestMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class GuestServiceImpl implements GuestService{

	private GuestMapper mapper;
	
	public ListProc getList(String word, int currentPage) {
		return new ListProc(mapper, word, currentPage);
	}
	
	
	public GuestDto read(long bno) {
		return mapper.read(bno);	
	}
	
	public void del(long bno) {
		mapper.del(bno);
	}
	
	public void write(GuestDto g) {
		mapper.write(g);
	}
	
	public void modify(GuestDto g) {
		mapper.modify(g);
	}
	
	public void reg(AccountDto a) {
		if(mapper.regCount(a)==0) {
			mapper.reg(a);
		}
	}
	
	public int regCount(AccountDto a) {
		return mapper.regCount(a);
	}
	
	public AccountDto log(AccountDto a) {
		int logCount = mapper.logCount(a);
		if(logCount==1) {
			return mapper.log(a);
		}else {
			return null;
		}
	}
	
}