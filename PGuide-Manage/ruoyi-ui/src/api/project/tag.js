import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listTag(query) {
  return request({
    url: '/project/tag/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getTag(tagsId) {
  return request({
    url: '/project/tag/' + tagsId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addTag(data) {
  return request({
    url: '/project/tag',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateTag(data) {
  return request({
    url: '/project/tag',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delTag(tagsId) {
  return request({
    url: '/project/tag/' + tagsId,
    method: 'delete'
  })
}
