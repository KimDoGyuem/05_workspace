package com.project.service;

import com.project.dto.AccountDto;
import com.project.dto.GuestDto;
import com.project.listproc.ListProc;

public interface GuestService {
	
	public ListProc getList(String word, int currentPage);
	
	public GuestDto read(long bno);
	public void del(long bno);
	public void write(GuestDto g);
	public void modify(GuestDto g);
	
	public void reg(AccountDto a);
	public int regCount(AccountDto a);
	
	public AccountDto log(AccountDto a);
}
