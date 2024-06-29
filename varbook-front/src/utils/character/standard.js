const parseContent = (content) => {
  const _ = content.trim().match(/[a-zA-Z0-9\s\u4e00-\u9fa5\uF900-\uFA2D]+/gi)
  return _ ? _.join('').replaceAll(/\s+/g, ' ') : ''
}
/**
 * @description Checking strings for api compliance - Judgement content and length requirements
 * @param {String} content
 * @return {{isValid: boolean, msg: string}}
 */
const checkContent = (content) => {
  const newContent = parseContent(content)
  const judgeResponse = {
    short: {
      isValid: false,
      msg: '请求过短，至少2个纯数字以外的字符（1个汉字、字母、空格、数字计为一个字符）'
    },
    long: {
      isValid: false,
      msg: '请求过长，应小于15个字符（1个汉字、字母、空格、数字计为一个字符）'
    },
    valid: {
      isValid: true,
      msg: newContent
    }
  }
  if (!newContent || Number(newContent) || newContent.length < 2) {
    return judgeResponse.short
  }
  if (newContent.length > 15) {
    return judgeResponse.long
  }
  return judgeResponse.valid
}

const STYLE_LANG = {
  smallHump: '小驼峰',
  bigHump: '大驼峰',
  smallSnake: '小蛇形',
  bigSnake: '大蛇形',
  spinal: '脊柱',
}

const parseNamedVariable = (namedVariables) => {
  const out = []
  if (namedVariables) {
    const keys = Object.keys(STYLE_LANG)
    keys.forEach((key) => {
      if (Object.prototype.hasOwnProperty.call(STYLE_LANG, key)) {
        out.push({
          style: STYLE_LANG[key],
          key,
          data: namedVariables[key]
        })
      }
    })
  }
  return out
}

export { checkContent, parseContent, parseNamedVariable, STYLE_LANG }
