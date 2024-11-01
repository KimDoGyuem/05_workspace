package com.project.mapper;

import java.util.ArrayList;

import com.project.dto.AccountDto;
import com.project.dto.GuestDto;
import com.project.dto.GetListDto;

public interface GuestMapper {
	public ArrayList<GuestDto> getList(GetListDto gl);
	public int getPostCount();
	
	public ArrayList<GuestDto> getSearchList(GetListDto gl);
	public int getSearchPostCount(String word);
	
	public GuestDto read(long bno);
	public void del(long bno);
	public void write(GuestDto g);
	public void modify(GuestDto g);
	
	public void reg(AccountDto a);
	public int regCount(AccountDto a);
	
	public AccountDto log(AccountDto a);
	public int logCount(AccountDto a);
	
}
