package org.pguide.studio.place.controller;

import com.ruoyi.common.core.domain.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author DKwms
 * @Date 2023 10 2023/10/24 19 40
 */

@RestController
@RequestMapping("/place/table")
public class StudioPlaceTableController {

    /**
     * 列举三天内time_block 及用户信息
     * @return
     */
    @GetMapping
    public R list(){
        return R.ok();
    }

    /**
     * 用户点击添加
     * @return
     */
    @PostMapping
    public R add(){

        return R.ok();
    }
}
