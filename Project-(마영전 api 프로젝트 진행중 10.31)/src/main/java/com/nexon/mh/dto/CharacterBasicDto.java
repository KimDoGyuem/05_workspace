
package com.nexon.mh.dto;

import java.util.List;

public class CharacterBasicDto {

    public String character_name;
    public String character_date_create;
    public String character_date_last_login;
    public String character_date_last_logout;
    public String character_class_name;
    public String character_gender;
    public Integer character_exp;
    public Integer character_level;
    public String cairde_name;
    public Integer title_count;
    public Integer id_title_count;
    public Integer total_title_count;
    public List<TitleStat> title_stat;
    public List<SkillAwakening> skill_awakening;
    public DressPoint dress_point;

}
