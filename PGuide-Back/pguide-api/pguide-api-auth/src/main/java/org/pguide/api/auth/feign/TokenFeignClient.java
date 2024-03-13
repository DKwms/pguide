package org.pguide.api.auth.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author DKwms
 * @Date 2023 10 2023/10/7 11 06
 */
@FeignClient(value = "pguide-auth")
public interface TokenFeignClient {

}
