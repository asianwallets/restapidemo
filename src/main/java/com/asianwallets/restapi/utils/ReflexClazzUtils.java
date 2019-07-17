
package com.asianwallets.restapi.utils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Reflection tool class
 *
 * @Author red
 * @Date: 2019/7/17 10:55
 * @Description: Reflection tool class
 */
public class ReflexClazzUtils {

    /**
     * Gets the attribute name and value in the object
     *
     * @param obj object
     * @return Gets the attribute name and value in the object
     */
    public static Map<String, String> getFieldNames(Object obj) {
        Map map = new LinkedHashMap<String, String>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            try {
                String varName = fields[i].getName();
                boolean accessFlag = fields[i].isAccessible();
                fields[i].setAccessible(true);
                Object object = fields[i].get(obj);
                map.put(varName, String.valueOf(object));
                fields[i].setAccessible(accessFlag);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

}
