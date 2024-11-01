package com.project.service;

import org.springframework.ui.Model;

public interface MhService {
	public String nameSearch(String name); 
	public void characterBasic(String ocid,Model model); 
	public void characterStat(String ocid,Model model);
	public void characterGuild(String ocid,Model model);
}
