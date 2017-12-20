package com.baiwang.bophttpapi.util;


import com.baiwang.bophttpapi.common.Constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 字符串工具类。
 *
 * @author shenluodong
 * @since 2017-08-01
 */
public abstract class StrUtils {

    private StrUtils() {
    }

    /**
     * 检查指定的字符串是否为空。
     * <ul>
     * <li>SysUtils.isEmpty(null) = true</li>
     * <li>SysUtils.isEmpty("") = true</li>
     * <li>SysUtils.isEmpty("   ") = true</li>
     * <li>SysUtils.isEmpty("abc") = false</li>
     * </ul>
     *
     * @param value 待检查的字符串
     * @return true/false
     */
    public static boolean isEmpty(String value) {
        int strLen;
        if (value == null || (strLen = value.length()) == 0 || "".equals(value)) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(value.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查指定的字符串列表是否不为空。
     *
     * @param values 字符串列表
     * @return true/false
     */
    public static boolean areNotEmpty(String... values) {
        boolean result = true;
        if (values == null || values.length == 0) {
            result = false;
        } else {
            for (String value : values) {
                result &= !isEmpty(value);
            }
        }
        return result;
    }

    /**
     * 把字符串解释为日期对象，采用yyyy-MM-dd HH:mm:ss的格式。
     */
    public static Date parseDateTime(String str) {
        DateFormat format = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
        format.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        try {
            return format.parse(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

