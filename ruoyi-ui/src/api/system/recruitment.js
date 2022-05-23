import request from '@/utils/request'

// 查询招聘列表
export function listRecruitment(query) {
  return request({
    url: '/system/recruitment/list',
    method: 'get',
    params: query
  })
}

// 查询招聘详细
export function getRecruitment(recruitId) {
  return request({
    url: '/system/recruitment/' + recruitId,
    method: 'get'
  })
}

// 新增招聘
export function addRecruitment(data) {
  return request({
    url: '/system/recruitment',
    method: 'post',
    data: data
  })
}

// 修改招聘
export function updateRecruitment(data) {
  return request({
    url: '/system/recruitment',
    method: 'put',
    data: data
  })
}

// 删除招聘
export function delRecruitment(recruitId) {
  return request({
    url: '/system/recruitment/' + recruitId,
    method: 'delete'
  })
}
