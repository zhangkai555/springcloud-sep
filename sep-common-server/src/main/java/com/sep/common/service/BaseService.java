package com.sep.common.service;

import com.sep.common.encryption.Algorithm;
import com.sep.common.encryption.MessageDigestUtils;

public abstract class BaseService {

    /**
     * 密码加密算法
     * @param password
     * @return
     */
    protected String encryptPassword(String password){
        return MessageDigestUtils.encrypt(password, Algorithm.SHA1);
    }

    /**
     * 生成API鉴权的Token
     * @param mobile
     * @param password
     * @return
     */
    protected String getToken(String mobile,String password){
        return MessageDigestUtils.encrypt(mobile+password, Algorithm.SHA1);
    }
}
