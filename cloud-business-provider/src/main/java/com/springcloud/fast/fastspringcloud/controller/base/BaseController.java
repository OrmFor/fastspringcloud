package com.springcloud.fast.fastspringcloud.controller.base;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

@Slf4j
public class BaseController {

    public static Map<String, String> getErrors(BindingResult result) {
        Map<String, String> map = Maps.newHashMap();
        List<FieldError> list = result.getFieldErrors();
        for (FieldError error : list) {
            map.put(error.getField(), error.getDefaultMessage());
        }
        return map;
    }

    @InitBinder
    public void setDisallowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("pageNumber", "pageSize", "pageBeginIndex", "expressionChainList", "orderBy");
    }

    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    public JSONObject getJsonFromRequest() {
        final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        try {
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = request.getReader();
            try {
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
            } finally {
                reader.close();
            }
            log.info("参数：" + builder);
            if (Strings.isNullOrEmpty(builder.toString())) {
                builder.append("{}");
                //throw new RuntimeException("data empty");
            }
            return JSONObject.parseObject(builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public static String readReqStr(HttpServletRequest request) {
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
            String line = null;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != reader) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("参数：" + sb);
        return sb.toString();
    }

    public String getDomain() {
        final HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();

        StringBuffer url = request.getRequestURL();
        String tempContextUrl = url.delete(url.length() -
                request.getRequestURI().length(), url.length()).append("/").toString();

        return tempContextUrl;
    }

    public JSONObject printArgs(Map<String, String> params) {
        log.info("-----下单获取参数开始-----");
        JSONObject json = new JSONObject();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            log.info(mapKey + ":" + mapValue);
            json.put(mapKey,mapValue);
        }
        log.info("-----下单获取参数结束-----");
        return json;
    }

    public void printNotifyArgs(String xml){
        log.info("支付回调参数==>"+xml);
    }

    public void printRefundNotifyArgs(String xml){
        log.info("退款回调参数==>"+xml);
    }

}
