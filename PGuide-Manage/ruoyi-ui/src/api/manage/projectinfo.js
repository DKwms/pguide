import request from '@/utils/request'

// 查询项目信息主表列表
export function listProjectinfo(query) {
  return request({
    url: '/manage/projectinfo/list',
    method: 'get',
    params: query
  })
}

// 查询项目信息主表详细
export function getProjectinfo(projectId) {
  return request({
    url: '/manage/projectinfo/' + projectId,
    method: 'get'
  })
}

// 新增项目信息主表
export function addProjectinfo(data) {
  return request({
    url: '/manage/projectinfo',
    method: 'post',
    data: data
  })
}

// 修改项目信息主表
export function updateProjectinfo(data) {
  return request({
    url: '/manage/projectinfo',
    method: 'put',
    data: data
  })
}

// 删除项目信息主表
export function delProjectinfo(projectId) {
  return request({
    url: '/manage/projectinfo/' + projectId,
    method: 'delete'
  })
}
