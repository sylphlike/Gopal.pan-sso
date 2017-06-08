package bing.Pan.sso.manage.controller;

import bing.Pan.sso.common.enums.ResponseCode;
import bing.Pan.sso.common.exception.ServiceException;
import bing.Pan.sso.common.response.Response;
import bing.Pan.sso.domain.bussinessobject.SsoSystemAddBo;
import bing.Pan.sso.domain.bussinessobject.SsoSystemBo;
import bing.Pan.sso.domain.entity.SsoSystem;
import bing.Pan.sso.service.SsoSystemService;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @crea : Created by intelliJ IDEA 16.1.3
 * @auth : bing.Pan
 * @mail : 15923508369@163.com
 * @date : 2017/3/21 9:43
 * @desc : 系统相关controller
 */

@Api(value = "SsoSystemController", description = "应用系统管理接口")
@RestController
@RequestMapping("/ssoSystem")
public class SsoSystemController extends BaseController{

    @Autowired private SsoSystemService ssoSystemService;


    @RequestMapping("/ssoSystemList")
    public Object ssoSystemList(@Valid @ModelAttribute SsoSystemBo ssoSystemBo, BindingResult result) throws Exception {

        checkValid(result);

        return new Response<>(ssoSystemService.findPageListByE(ssoSystemBo));
    }

    @RequestMapping("/addAUPdateSsoSystem")
    public Object addAUPdateSsoSystem(@Valid @ModelAttribute SsoSystemAddBo ssoSystemAddBo, BindingResult result) throws Exception {
        checkValid(result);
        SsoSystem ssoSystem = new SsoSystem();
        BeanUtils.copyProperties(ssoSystemAddBo,ssoSystem);
        ssoSystemService.insertOrUpdate(ssoSystem,getCurrentUser());
        return new Response<>();

    }

    @RequestMapping("/getSsoSystemById")
    public Object getSsoSystemById(Long id) throws ServiceException {
        if(ObjectUtils.isEmpty(id))
            throw new ServiceException(ResponseCode.CLIENT_PARAM_MISS,"传入的应用系统ID为空!");

        return new Response<>(ssoSystemService.findById(id));

    }


}
