import request from '@/utils/request'

// 查询项目需求招募信息列表
export function listRecruitinfo(query) {
  return request({
    url: '/manage/recruitinfo/list',
    method: 'get',
    params: query
  })
}

// 查询项目需求招募信息详细
export function getRecruitinfo(recruitId) {
  return request({
    url: '/manage/recruitinfo/' + recruitId,
    method: 'get'
  })
}

// 新增项目需求招募信息
export function addRecruitinfo(data) {
  return request({
    url: '/manage/recruitinfo',
    method: 'post',
    data: data
  })
}

// 修改项目需求招募信息
export function updateRecruitinfo(data) {
  return request({
    url: '/manage/recruitinfo',
    method: 'put',
    data: data
  })
}

// 删除项目需求招募信息
export function delRecruitinfo(recruitId) {
  return request({
    url: '/manage/recruitinfo/' + recruitId,
    method: 'delete'
  })
}
