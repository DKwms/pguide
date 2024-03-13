import request from '@/utils/request'

// 查询需求类型字典表列表
export function listNeedtypedict(query) {
  return request({
    url: '/manage/needtypedict/list',
    method: 'get',
    params: query
  })
}

// 查询需求类型字典表详细
export function getNeedtypedict(needTypeId) {
  return request({
    url: '/manage/needtypedict/' + needTypeId,
    method: 'get'
  })
}

// 新增需求类型字典表
export function addNeedtypedict(data) {
  return request({
    url: '/manage/needtypedict',
    method: 'post',
    data: data
  })
}

// 修改需求类型字典表
export function updateNeedtypedict(data) {
  return request({
    url: '/manage/needtypedict',
    method: 'put',
    data: data
  })
}

// 删除需求类型字典表
export function delNeedtypedict(needTypeId) {
  return request({
    url: '/manage/needtypedict/' + needTypeId,
    method: 'delete'
  })
}
