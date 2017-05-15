package bing.Pan.sso.manage.controller;

import bing.Pan.sso.common.enums.ResponseCode;
import bing.Pan.sso.common.exception.ServiceException;
import bing.Pan.sso.common.response.Response;
import bing.Pan.sso.domain.bussinessobject.PageBo;
import bing.Pan.sso.service.SystemInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @crea : Created by intelliJ IDEA 16.1.3
 * @auth : bing.Pan
 * @mail : 15923508369@163.com
 * @date : 2017/3/21 9:43
 * @desc : 系统相关controller
 */

@Api(value = "SystemUserController", description = "系统管理接口")
@RestController
public class SystemInfoController extends BaseController{

    @Autowired private SystemInfoService systemInfoService;


    /**
     * 系统管理用户列表
     * @return
     * @throws ServiceException
     */
    @ApiOperation(value = "系统管理列表")
    @RequestMapping(value = "/sysInfoPageList", method = RequestMethod.POST)
    public Object systemUserList(@Valid @ModelAttribute PageBo pageBo, BindingResult result)  throws ServiceException {
        if (result.hasErrors()) {
                throw new ServiceException(ResponseCode.CLIENT_PARAM_ERR);
        }
        return new Response<>(systemInfoService.sysInfoPageList(pageBo));
    }


    public Object andOrupdateSysInfo(){
        return null;
    }

}
