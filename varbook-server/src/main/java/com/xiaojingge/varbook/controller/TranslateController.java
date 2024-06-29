package com.xiaojingge.varbook.controller;

import com.google.common.collect.Maps;
import com.xiaojingge.varbook.common.response.ApiResult;
import com.xiaojingge.varbook.domain.XiaoNiuTranslateResponse;
import com.xiaojingge.varbook.util.TranslateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 翻译控制器
 *
 * @author lijing
 * @date 2024-06-29
 */
@RestController
@RequestMapping("/translate")
public class TranslateController {

    /**
     * 翻译
     *
     * @param text
     * @return {@link ApiResult }
     */
    @PostMapping("/translate")
    public ApiResult translate(String text) {
        XiaoNiuTranslateResponse translateResponse = TranslateUtil.translate(text);
        if (StringUtils.isNotBlank(translateResponse.getTgt_text())) {
            Map<String, Object> result = Maps.newHashMap();
            String tgtText = translateResponse.getTgt_text();
            result.put("smallHump", TranslateUtil.toCamelCase(tgtText));
            result.put("bigHump", TranslateUtil.toUpperCamelCase(tgtText));
            result.put("smallSnake", TranslateUtil.toSnakeCase(tgtText));
            result.put("bigSnake", TranslateUtil.toUpperSnakeCase(tgtText));
            result.put("spinal", TranslateUtil.toKebabCase(tgtText));
            return ApiResult.ok(result);
        } else {
            return ApiResult.fail(translateResponse.getError_msg());
        }
    }
}