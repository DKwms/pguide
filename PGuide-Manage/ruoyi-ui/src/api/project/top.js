import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listTop(query) {
  return request({
    url: '/project/top/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getTop(logTypeId) {
  return request({
    url: '/project/top/' + logTypeId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addTop(data) {
  return request({
    url: '/project/top',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateTop(data) {
  return request({
    url: '/project/top',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delTop(logTypeId) {
  return request({
    url: '/project/top/' + logTypeId,
    method: 'delete'
  })
}
