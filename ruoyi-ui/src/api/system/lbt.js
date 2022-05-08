import request from '@/utils/request'

// 查询轮播图列表
export function listLbt(query) {
  return request({
    url: '/system/lbt/list',
    method: 'get',
    params: query
  })
}

// 查询轮播图详细
export function getLbt(lbtId) {
  return request({
    url: '/system/lbt/' + lbtId,
    method: 'get'
  })
}

// 新增轮播图
export function addLbt(data) {
  return request({
    url: '/system/lbt',
    method: 'post',
    data: data
  })
}

// 修改轮播图
export function updateLbt(data) {
  return request({
    url: '/system/lbt',
    method: 'put',
    data: data
  })
}

// 删除轮播图
export function delLbt(lbtId) {
  return request({
    url: '/system/lbt/' + lbtId,
    method: 'delete'
  })
}
