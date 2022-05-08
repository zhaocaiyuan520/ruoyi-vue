import request from '@/utils/request'

// 查询主页详情列表
export function listInfo(query) {
  return request({
    url: '/system/info/list',
    method: 'get',
    params: query
  })
}

// 查询主页详情详细
export function getInfo(homeId) {
  return request({
    url: '/system/info/' + homeId,
    method: 'get'
  })
}

// 新增主页详情
export function addInfo(data) {
  return request({
    url: '/system/info',
    method: 'post',
    data: data
  })
}

// 修改主页详情
export function updateInfo(data) {
  return request({
    url: '/system/info',
    method: 'put',
    data: data
  })
}

// 删除主页详情
export function delInfo(homeId) {
  return request({
    url: '/system/info/' + homeId,
    method: 'delete'
  })
}
