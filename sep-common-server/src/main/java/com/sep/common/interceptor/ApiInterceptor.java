package com.sep.common.interceptor;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sun.security.provider.MD5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class ApiInterceptor implements HandlerInterceptor {

    /*private static final Logger logger = LoggerFactory.getLogger(ApiInterceptor.class);
    private String salt = "ed4ffcd453efab32";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        logger.info("进入拦截器");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "application/json;charset=utf8");
        String url = getUrlAuthenticationApi(request);        //这里是MD5加密算法
        String sign = DigestUtils.md5Hex((url+salt).getBytes());
        String signature = request.getHeader("signature");
        logger.info("加密前传入的签名" + signature);
        logger.info("后端加密后的签名" + sign);
        if (sign.equals(signature)) {
            return true;
        } else {            //签名错误
            response.getWriter().print("签名错误");
            response.getWriter().close();
            return false;
        }
    }

    private String getUrlAuthenticationApi(HttpServletRequest request) throws IOException{

        if(StringUtils.isBlank(request.getHeader("token"))){
            return "";
        }
        Map<String,String> paramMap = requestParamToMap(request);
        paramMap.put("token",request.getHeader("token"));

        List<String> keys = new ArrayList<String>(paramMap.keySet());
        Collections.sort(keys);
        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            // 输入参数中包含下划线，将其转化成"."
            key.replace("_",".");
            String value = paramMap.get(key);
            try {
                value = URLEncoder.encode(value,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        logger.info("url : " + prestr);
        return prestr;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    private Map<String,String> requestParamToMap(HttpServletRequest request) throws IOException{

        InputStream is = null;
        StringBuilder sb = new StringBuilder();
        try
        {
            is = request.getInputStream();

            byte[] b = new byte[4096];
            for (int n; (n = is.read(b)) != -1;)
            {
                sb.append(new String(b, 0, n));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != is)
            {
                try
                {
                    is.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return  JSON.parseObject(sb.toString(),Map.class);
    }*/
}