import request from '@/utils/request'

// 查询比赛信息列表
export function listCptinfo(query) {
  return request({
    url: '/cmsmanage/cptinfo/list',
    method: 'get',
    params: query
  })
}

// 查询比赛信息详细
export function getCptinfo(cptId) {
  return request({
    url: '/cmsmanage/cptinfo/' + cptId,
    method: 'get'
  })
}

// 新增比赛信息
export function addCptinfo(data) {
  return request({
    url: '/cmsmanage/cptinfo',
    method: 'post',
    data: data
  })
}

// 修改比赛信息
export function updateCptinfo(data) {
  return request({
    url: '/cmsmanage/cptinfo',
    method: 'put',
    data: data
  })
}

// 删除比赛信息
export function delCptinfo(cptId) {
  return request({
    url: '/cmsmanage/cptinfo/' + cptId,
    method: 'delete'
  })
}
