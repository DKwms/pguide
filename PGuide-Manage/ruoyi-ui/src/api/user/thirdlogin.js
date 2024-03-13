import request from '@/utils/request'


export function listTable() {
  return request({
    url: '/api/tddb',
    method: 'get'
  })
}
