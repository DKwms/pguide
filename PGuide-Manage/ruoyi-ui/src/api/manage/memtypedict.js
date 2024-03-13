import request from '@/utils/request'

// 查询成员属性字典表列表
export function listMemtypedict(query) {
  return request({
    url: '/manage/memtypedict/list',
    method: 'get',
    params: query
  })
}

// 查询成员属性字典表详细
export function getMemtypedict(memberTypeId) {
  return request({
    url: '/manage/memtypedict/' + memberTypeId,
    method: 'get'
  })
}

// 新增成员属性字典表
export function addMemtypedict(data) {
  return request({
    url: '/manage/memtypedict',
    method: 'post',
    data: data
  })
}

// 修改成员属性字典表
export function updateMemtypedict(data) {
  return request({
    url: '/manage/memtypedict',
    method: 'put',
    data: data
  })
}

// 删除成员属性字典表
export function delMemtypedict(memberTypeId) {
  return request({
    url: '/manage/memtypedict/' + memberTypeId,
    method: 'delete'
  })
}
