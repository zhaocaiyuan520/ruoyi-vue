import request from '@/utils/request'

// 查询主页详情列表
export function listArticle(query) {
  return request({
    url: '/system/article/list',
    method: 'get',
    params: query
  })
}

// 查询主页详情详细
export function getArticle(articleId) {
  return request({
    url: '/system/article/' + articleId,
    method: 'get'
  })
}

// 新增主页详情
export function addArticle(data) {
  return request({
    url: '/system/article',
    method: 'post',
    data: data
  })
}

// 修改主页详情
export function updateArticle(data) {
  return request({
    url: '/system/article',
    method: 'put',
    data: data
  })
}

// 删除主页详情
export function delArticle(articleId) {
  return request({
    url: '/system/article/' + articleId,
    method: 'delete'
  })
}
