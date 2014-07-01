/*
 * @(#)MD5Encoder.java 2013-12-18
 * 
 * Copy Right@ coderme.cn
 */ 

package com.coderme.core.util.encoder;

import org.springframework.security.authentication.encoding.PasswordEncoder;


/**
 * <pre>
 * @author coderme
 *
 *
 * 创建日期: 2013-12-18
 * 修改人 :  
 * 修改说明: 
 * 评审人 ：
 * </pre>
 */
public class MD5Encoder implements PasswordEncoder {

    /* (non-Javadoc)
     * @see org.springframework.security.authentication.encoding.PasswordEncoder#encodePassword(java.lang.String, java.lang.Object)
     */
    @Override
    public String encodePassword(String arg0, Object arg1) {
        return MD5.getMD5ofStr(arg0);
    }

    /* (non-Javadoc)
     * @see org.springframework.security.authentication.encoding.PasswordEncoder#isPasswordValid(java.lang.String, java.lang.String, java.lang.Object)
     */
    @Override
    public boolean isPasswordValid(String encPwd, String origPwd, Object salt) {
        return encPwd.equals(encodePassword(origPwd, salt));
    }

}
