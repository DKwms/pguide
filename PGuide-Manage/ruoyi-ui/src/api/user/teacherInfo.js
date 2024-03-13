import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listInfo(query) {
  return request({
    url: '/project/info/teacher/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getInfo(teacherId) {
  return request({
    url: '/project/info/teacher' + teacherId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addInfo(data) {
  return request({
    url: '/project/info/teacher',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateInfo(data) {
  return request({
    url: '/project/info/teacher',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delInfo(teacherId) {
  return request({
    url: '/project/info/teacher' + teacherId,
    method: 'delete'
  })
}
