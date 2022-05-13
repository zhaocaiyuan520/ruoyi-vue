import request from '@/utils/request'

// 查询出版物模块详情列表
export function listPublication(query) {
  return request({
    url: '/system/publication/list',
    method: 'get',
    params: query
  })
}

// 查询出版物模块详情详细
export function getPublication(id) {
  return request({
    url: '/system/publication/' + id,
    method: 'get'
  })
}

// 新增出版物模块详情
export function addPublication(data) {
  return request({
    url: '/system/publication',
    method: 'post',
    data: data
  })
}

// 修改出版物模块详情
export function updatePublication(data) {
  return request({
    url: '/system/publication',
    method: 'put',
    data: data
  })
}

// 删除出版物模块详情
export function delPublication(id) {
  return request({
    url: '/system/publication/' + id,
    method: 'delete'
  })
}
