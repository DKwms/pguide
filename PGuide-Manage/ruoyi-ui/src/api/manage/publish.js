import request from '@/utils/request'

// 查询项目信息主表列表
export function listPublishVo(query) {
  return request({
    url: '/api/mms/publish/list',
    method: 'get',
    params: query
  })
}

export function checked(query) {
  return request({
    url: '/api/mms/publish/sys/checked',
    method: 'post',
    data: query
  })
}

export function publish(query) {
  return request({
    url: '/api/mms/publish/sys/publish',
    method: 'post',
    data: query
  })
}
export function stopPublish(query) {
  return request({
    url: '/api/mms/publish/sys/stop',
    method: 'post',
    data: query
  })
}


export function unpass(query) {
  return request({
    url: '/api/mms/publish/sys/unpass',
    method: 'post',
    data: query
  })
}
