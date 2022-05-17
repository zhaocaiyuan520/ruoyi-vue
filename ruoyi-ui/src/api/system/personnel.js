import request from '@/utils/request'

// 查询人员详情列表
export function listPersonnel(query) {
  return request({
    url: '/system/personnel/list',
    method: 'get',
    params: query
  })
}

// 查询人员详情详细
export function getPersonnel(personnelId) {
  return request({
    url: '/system/personnel/' + personnelId,
    method: 'get'
  })
}

// 新增人员详情
export function addPersonnel(data) {
  return request({
    url: '/system/personnel',
    method: 'post',
    data: data
  })
}

// 修改人员详情
export function updatePersonnel(data) {
  return request({
    url: '/system/personnel',
    method: 'put',
    data: data
  })
}

// 删除人员详情
export function delPersonnel(personnelId) {
  return request({
    url: '/system/personnel/' + personnelId,
    method: 'delete'
  })
}
