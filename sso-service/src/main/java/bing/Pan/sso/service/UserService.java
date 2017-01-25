package bing.Pan.sso.service;

import bing.Pan.sso.domain.entity.SsoUser;
import bing.Pan.sso.mapper.mapperInterface.SsoUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @crea :Created by intelliJ IDEA 16.1.1 .
 * @auth :bing.Pan 15923508369@163.com .
 * @date :2017/1/17 18:52
 * @desc :
 */

@Service
public class UserService implements BaseService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired private SsoUserMapper userMapper;

    public SsoUser selectByPrimaryKey(){
        return userMapper.selectByPrimaryKey(1L);
    }




}