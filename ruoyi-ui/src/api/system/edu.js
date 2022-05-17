import request from '@/utils/request'

// 查询教育经历列表
export function listEdu(query) {
  return request({
    url: '/system/edu/list',
    method: 'get',
    params: query
  })
}

// 查询教育经历详细
export function getEdu(eduId) {
  return request({
    url: '/system/edu/' + eduId,
    method: 'get'
  })
}

// 新增教育经历
export function addEdu(data) {
  return request({
    url: '/system/edu',
    method: 'post',
    data: data
  })
}

// 修改教育经历
export function updateEdu(data) {
  return request({
    url: '/system/edu',
    method: 'put',
    data: data
  })
}

// 删除教育经历
export function delEdu(eduId) {
  return request({
    url: '/system/edu/' + eduId,
    method: 'delete'
  })
}
