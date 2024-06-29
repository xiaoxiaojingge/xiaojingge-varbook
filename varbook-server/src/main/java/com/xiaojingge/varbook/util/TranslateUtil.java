package com.xiaojingge.varbook.util;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSONObject;
import com.xiaojingge.varbook.domain.XiaoNiuTranslateResponse;

import java.util.Map;

/**
 * 翻译工具类
 *
 * @author lijing
 * @date 2024-06-29
 */
public class TranslateUtil {

    /**
     * 翻译 API URL
     */
    private static final String API_URL = "https://api.niutrans.com/NiuTransServer/translation";

    /**
     * 翻译 API KEY
     */
    private static final String API_KEY = "xxxxxx";

    /**
     * 翻译
     *
     * @param text
     * @return {@link XiaoNiuTranslateResponse }
     */
    public static XiaoNiuTranslateResponse translate(String text) {
        Map<String, Object> params = Map.of(
                "from", "zh",
                "to", "en",
                "apikey", API_KEY,
                "src_text", text,
                "dictNo", "",
                "memoryNo", ""
        );
        String response = HttpUtil.post(API_URL, params);
        return JSONObject.parseObject(response, XiaoNiuTranslateResponse.class);
    }

    /**
     * 小驼峰转换（小写开头，后续单词首字母大写）
     *
     * @param input
     * @return {@link String }
     */
    public static String toCamelCase(String input) {
        StringBuilder result = new StringBuilder();
        String[] parts = input.split("\\s+");
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (i == 0) {
                result.append(part.toLowerCase());
            } else {
                result.append(Character.toUpperCase(part.charAt(0)));
                if (part.length() > 1) {
                    result.append(part.substring(1).toLowerCase());
                }
            }
        }
        return result.toString();
    }


    /**
     * 大驼峰转换（每个单词首字母大写）
     *
     * @param input
     * @return {@link String }
     */
    public static String toUpperCamelCase(String input) {
        String camelCase = toCamelCase(input);
        return camelCase.substring(0, 1).toUpperCase() + camelCase.substring(1);
    }

    /**
     * 小蛇形转换（单词间用下划线连接，全部小写）
     *
     * @param input
     * @return {@link String }
     */
    public static String toSnakeCase(String input) {
        return input.replaceAll("\\s+", "_").toLowerCase();
    }


    /**
     * 大蛇形转换（单词间用下划线连接，全部大写）
     *
     * @param input
     * @return {@link String }
     */
    public static String toUpperSnakeCase(String input) {
        return toSnakeCase(input).toUpperCase();
    }


    /**
     * 脊柱型转换（单词间用连字符连接）
     *
     * @param input
     * @return {@link String }
     */
    public static String toKebabCase(String input) {
        return input.replaceAll("\\s+", "-").toLowerCase();
    }

    public static void main(String[] args) {
        String inputData = "Small Hump Data";
        System.out.println("小驼峰命名：" + toCamelCase(inputData));
        System.out.println("大驼峰命名：" + toUpperCamelCase(inputData));
        System.out.println("小蛇形命名：" + toSnakeCase(inputData));
        System.out.println("大蛇形命名：" + toUpperSnakeCase(inputData));
        System.out.println("脊柱命名：" + toKebabCase(inputData));
    }
}
