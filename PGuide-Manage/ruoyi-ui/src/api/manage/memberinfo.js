import request from '@/utils/request'

// 查询项目成员信息表列表
export function listMemberinfo(query) {
  return request({
    url: '/manage/memberinfo/list',
    method: 'get',
    params: query
  })
}

// 查询项目成员信息表详细
export function getMemberinfo(projectId) {
  return request({
    url: '/manage/memberinfo/' + projectId,
    method: 'get'
  })
}

// 新增项目成员信息表
export function addMemberinfo(data) {
  return request({
    url: '/manage/memberinfo',
    method: 'post',
    data: data
  })
}

// 修改项目成员信息表
export function updateMemberinfo(data) {
  return request({
    url: '/manage/memberinfo',
    method: 'put',
    data: data
  })
}

// 删除项目成员信息表
export function delMemberinfo(projectId) {
  return request({
    url: '/manage/memberinfo/' + projectId,
    method: 'delete'
  })
}
