import request from '@/utils/request'
// 翻译
const translate = (params) =>
  request({
    url: '/translate/translate',
    method: 'post',
    params
  })

export { translate }
