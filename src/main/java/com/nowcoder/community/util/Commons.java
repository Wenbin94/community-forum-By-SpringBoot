package com.nowcoder.community.util;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;



/**
 * 常用工具
 */
@Component
public class Commons {



    /**
     * 数组转字符串
     * @param arr 数组
     * @return String
     */
    public static String arrayToString(String[] arr) {
        StringBuffer buffer = new StringBuffer();
        String[] temp = arr;
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            String item = temp[i];
            buffer.append(",").append(item);
        }
        return buffer.length() > 0 ? buffer.substring(1) : buffer.toString();
    }


    /**
     * 显示文章内容，转换markdown为HTML
     * @param markdown
     * @return
     */
    public static String article(String markdown) {
        if (StringUtils.isNotBlank(markdown)) {
            markdown = markdown.replace("<!--more-->", "\r\n");
            markdown = markdown.replace("<!-- more -->", "\r\n");
            return SpecialUtil.markdownToHtml(markdown);
        }
        return "";
    }



}
