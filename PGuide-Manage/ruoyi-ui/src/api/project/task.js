import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function getTaskDto(query) {
  return request({
    url: '/project/task/list/self',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】列表
export function listTask(query) {
  return request({
    url: '/project/task/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getTask(taskId) {
  return request({
    url: '/project/task/' + taskId,
    method: 'get'
  })
}

/**
 * 获取一个
 */

/**
 * ========================================新增
 * @param data
 * @returns {AxiosPromise}
 */
export function addTask(data) {
  return request({
    url: '/project/task',
    method: 'post',
    data: data
  })
}
// subAddWay Add the role
export function addTaskByRole(data){
  return request({
    url:"/project/task/add/mut",
    method:"post",
    data:data
  })
}

// 修改【请填写功能名称】
export function updateTask(data) {
  return request({
    url: '/project/task',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delTask(taskId) {
  return request({
    url: '/project/task/' + taskId,
    method: 'delete'
  })
}
