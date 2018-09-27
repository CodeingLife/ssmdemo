package com.ssmdemo.service;

import java.util.List;

import com.ssmdemo.vo.PersonVo;

public interface PersonService {
	 
    //����һ��Person����
    void insert(PersonVo p);
    
    //��������idɾ��Person����
    void deleteById(String id);
    
    //�޸�һ��person����
    void update(PersonVo p);
    
    //��������id����Person����
    PersonVo selectById(String id);
    
    //��������Person���󣬷��ؼ�������
    List<PersonVo> selectAll();
}
