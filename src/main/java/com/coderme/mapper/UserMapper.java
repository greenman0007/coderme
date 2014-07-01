/*
 * @(#)UserMapper.java 2013-12-11
 * 
 * Copy Right@ coderme.cn
 */ 

package com.coderme.mapper;

import org.springframework.stereotype.Repository;

import com.coderme.bean.User;


/**
 * <pre>
 * @author coderme
 *
 *
 * 创建日期: 2013-12-11
 * 修改人 :  
 * 修改说明: 
 * 评审人 ：
 * </pre>
 */
@Repository
public interface UserMapper {

    public void save(User user);
    
    public User findUserByName(String userName);
    
    public String findPwdByName(String userName);
}
