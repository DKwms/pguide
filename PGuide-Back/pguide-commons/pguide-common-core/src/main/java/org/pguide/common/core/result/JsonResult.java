package org.pguide.common.core.result;

import lombok.Data;
import org.pguide.common.core.constant.HttpStatus;

import java.net.DatagramSocket;

/**
 * @author StevenZhang
 * @date 2023/8/17
 * @description 请在JsonResult和JsonResult2中选择一个或者自己书写合适的返回值接口
 */
@Data
public class JsonResult<T> {

    private Integer code;
    private String message;
    private T data;

    private JsonResult() {
    }

    //统一返回值构建方法
    public static <T> JsonResult<T> build(Integer code, String message, T data) {
        //对象初始化
        JsonResult<T> result = new JsonResult<>();
        if (data != null) {
            result.setData(data);
        }
        result.setCode(code);
        result.setMessage(message);

        return result;
    }

    //====================================================成功返回重载====================================================
    public static <T> JsonResult<T> success() {
        return JsonResult.success("操作成功", null);
    }

    public static <T> JsonResult<T> success(T data) {
        return JsonResult.success("操作成功", data);
    }

    public static <T> JsonResult<T> success(String message) {
        return JsonResult.success(message, null);
    }

    public static <T> JsonResult<T> success(String message, T data) {
        return build(HttpStatus.SUCCESS.value(), message, data);
    }

    //====================================================失败返回重载====================================================
    public static <T> JsonResult<T> error() {
        return JsonResult.success("操作失败", null);
    }

    public static <T> JsonResult<T> error(T data) {
        return JsonResult.success("操作失败", data);
    }

    public static <T> JsonResult<T> error(String message) {
        return JsonResult.success(message, null);
    }

    public static <T> JsonResult<T> error(String message, T data) {
        return build(HttpStatus.ERROR.value(), message, data);
    }

    public static <T> JsonResult<T> error(Integer code,String message,T data){
        return build(code,message,data);
    }

    public static <T> JsonResult<T> error(Integer code,String message){
        return build(code,message,null);
    }

    //====================================================警告返回重载====================================================
    public static <T> JsonResult<T> warn() {
        return JsonResult.success("操作警告", null);
    }

    public static <T> JsonResult<T> warn(T data) {
        return JsonResult.success("操作警告", data);
    }

    public static <T> JsonResult<T> warn(String message) {
        return JsonResult.success(message, null);
    }

    public static <T> JsonResult<T> warn(String message, T data) {
        return build(HttpStatus.WARN.value(), message, data);
    }

    //用户自定义Message或者Code的修改方法
    public JsonResult<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

    public JsonResult<T> message(String message) {
        this.setMessage(message);
        return this;
    }


    private JsonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }




}
