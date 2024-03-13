import request from '@/utils/request'

// 查询组织字典列表
export function listOrgdict(query) {
  return request({
    url: '/cmsmanage/orgdict/list',
    method: 'get',
    params: query
  })
}

// 查询组织字典详细
export function getOrgdict(orgId) {
  return request({
    url: '/cmsmanage/orgdict/' + orgId,
    method: 'get'
  })
}

// 新增组织字典
export function addOrgdict(data) {
  return request({
    url: '/cmsmanage/orgdict',
    method: 'post',
    data: data
  })
}

// 修改组织字典
export function updateOrgdict(data) {
  return request({
    url: '/cmsmanage/orgdict',
    method: 'put',
    data: data
  })
}

// 删除组织字典
export function delOrgdict(orgId) {
  return request({
    url: '/cmsmanage/orgdict/' + orgId,
    method: 'delete'
  })
}
