import request from '@/utils/request'

// 查询课件列表
export function listCourse(query) {
  return request({
    url: '/system/course/list',
    method: 'get',
    params: query
  })
}

// 查询课件详细
export function getCourse(courseId) {
  return request({
    url: '/system/course/' + courseId,
    method: 'get'
  })
}

// 新增课件
export function addCourse(data) {
  return request({
    url: '/system/course',
    method: 'post',
    data: data
  })
}

// 修改课件
export function updateCourse(data) {
  return request({
    url: '/system/course',
    method: 'put',
    data: data
  })
}

// 删除课件
export function delCourse(courseId) {
  return request({
    url: '/system/course/' + courseId,
    method: 'delete'
  })
}
