import request from '@/utils/request'

// 查询项目从属信息表列表
export function listBelonginfo(query) {
  return request({
    url: '/manage/belonginfo/list',
    method: 'get',
    params: query
  })
}

// 查询项目从属信息表详细
export function getBelonginfo(belongId) {
  return request({
    url: '/manage/belonginfo/' + belongId,
    method: 'get'
  })
}

// 新增项目从属信息表
export function addBelonginfo(data) {
  return request({
    url: '/manage/belonginfo',
    method: 'post',
    data: data
  })
}

// 修改项目从属信息表
export function updateBelonginfo(data) {
  return request({
    url: '/manage/belonginfo',
    method: 'put',
    data: data
  })
}

// 删除项目从属信息表
export function delBelonginfo(belongId) {
  return request({
    url: '/manage/belonginfo/' + belongId,
    method: 'delete'
  })
}
