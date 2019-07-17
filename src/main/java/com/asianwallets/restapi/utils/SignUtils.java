package com.asianwallets.restapi.utils;

import org.apache.commons.beanutils.PropertyUtilsBean;

import java.beans.PropertyDescriptor;
import java.util.*;

/**
 * Signature utility class
 *
 * @Author red
 * @Date: 2019/7/17 10:55
 * @Description: Signature utility class
 */
public class SignUtils {

    /**
     * Generate offline signature
     *
     * @param obj    Input entity
     * @param md5Key md5Key
     * @return Generate offline signature
     */
    public static String createOfflineSign(Object obj, String md5Key) {
        //Get the property value Map corresponding to the object property name
        Map<String, String> paramMap = ReflexClazzUtils.getFieldNames(obj);
        //Sort,empty,and sort property values alphabetically by property name
        String signature = getSignStr(paramMap);
        return Md5Util.getMD5String(signature + md5Key);
    }

    /**
     * Generate online signature
     *
     * @param obj        Input entity
     * @param privateKey privateKey
     * @return Generate online signature
     */
    public static String createOnelineSign(Object obj, String privateKey) {
        HashMap<String, String> map = beanToMap(obj);
        byte[] msg = getSignStr(map).getBytes();
        String signMsg = null;
        try {
            signMsg = RSAUtils.sign(msg, privateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return signMsg;
    }


    public static HashMap<String, String> beanToMap(Object obj) {
        HashMap<String, String> params = new HashMap<String, String>(0);
        try {
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);
            for (int i = 0; i < descriptors.length; i++) {
                String name = descriptors[i].getName();
                if (!"class".equals(name)) {
                    params.put(name, String.valueOf(propertyUtilsBean.getNestedProperty(obj, name)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params;
    }

    /**
     * Sort, empty, and sort property values alphabetically by property name
     *
     * @param m parameter map
     * @return Clear text before signing
     */
    private static String getSignStr(Map<String, String> m) {
        String signStr = null;
        if (m != null) {
            Map<String, String> map = new TreeMap<>();
            Set<String> ks = m.keySet();
            for (String key : ks) {
                if (key != null && !"".equals(key)) {
                    String value = m.get(key);
                    if (value != null && !"".equals(value) && !"null".equals(value)) {
                        map.put(key, value);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                String val = map.get(key);
                if (val != null && !"".equals(val) && !"null".equals(val)) {
                    sb.append(val.trim());
                }
            }
            signStr = sb.toString();
            System.out.println("Clear text before signing: " + signStr);

        }
        return signStr;
    }
}
