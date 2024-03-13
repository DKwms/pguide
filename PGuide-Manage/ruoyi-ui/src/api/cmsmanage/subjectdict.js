import request from '@/utils/request'

// 查询学科字典列表
export function listSubjectdict(query) {
  return request({
    url: '/cmsmanage/subjectdict/list',
    method: 'get',
    params: query
  })
}

// 查询学科字典详细
export function getSubjectdict(subjectId) {
  return request({
    url: '/cmsmanage/subjectdict/' + subjectId,
    method: 'get'
  })
}

// 新增学科字典
export function addSubjectdict(data) {
  return request({
    url: '/cmsmanage/subjectdict',
    method: 'post',
    data: data
  })
}

// 修改学科字典
export function updateSubjectdict(data) {
  return request({
    url: '/cmsmanage/subjectdict',
    method: 'put',
    data: data
  })
}

// 删除学科字典
export function delSubjectdict(subjectId) {
  return request({
    url: '/cmsmanage/subjectdict/' + subjectId,
    method: 'delete'
  })
}
