package com.pguide.project.domain.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sinahar
 * @version 1.0
 * @description: TODO
 * @date 2023/10/9 11:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R<T> {

    private static final String code = "1";

    private String msg = "holle World!";

    private T data;

    public R(String msg) {
        this.msg = msg;
    }

    public R(T data) {
        this.data = data;
    }
}
