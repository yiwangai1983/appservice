package com.superc.business.httpRequest;

import com.superc.commons.bean.ResponseBeanTest;
import com.superc.commons.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by chao on 15/8/31.
 */
@Controller
@RequestMapping("/c")
public class TestHttpRequest extends BaseController {

    @ResponseBody
    @RequestMapping(value = "/testHttpRequest", method = {RequestMethod.POST,RequestMethod.GET})
    public ResponseBeanTest testHttpRequest(HttpServletRequest request, @RequestParam(value = "privateKey", required = true) String privateKey) {
        ResponseBeanTest testBean = new ResponseBeanTest();
        String requestJsonStr;
        try {
            requestJsonStr = super.inputStreamToJsonStr(request.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } 
        testBean.setCode(1);
        testBean.setMessage("请求成功");
        return testBean;
    }

}
