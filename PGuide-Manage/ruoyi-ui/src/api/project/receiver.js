import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listReceiver(query) {
  return request({
    url: '/project/receiver/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getReceiver(taskId) {
  return request({
    url: '/project/receiver/' + taskId,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addReceiver(data) {
  return request({
    url: '/project/receiver',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateReceiver(data) {
  return request({
    url: '/project/receiver',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delReceiver(taskId) {
  return request({
    url: '/project/receiver/' + taskId,
    method: 'delete'
  })
}
