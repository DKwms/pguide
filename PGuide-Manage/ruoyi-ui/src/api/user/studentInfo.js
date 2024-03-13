import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listInfo(query) {
  return request({
    url: '/project/info/student/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getInfo(studentId) {
  return request({
    url: '/project/info/student' + studentId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addInfo(data) {
  return request({
    url: '/project/info/student',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateInfo(data) {
  return request({
    url: '/project/info/student',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delInfo(studentId) {
  return request({
    url: '/project/info/student' + studentId,
    method: 'delete'
  })
}
