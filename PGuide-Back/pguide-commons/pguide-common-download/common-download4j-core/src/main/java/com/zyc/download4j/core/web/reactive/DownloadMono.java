package com.zyc.download4j.core.web.reactive;

import com.zyc.download4j.core.concept.ValueContainer;
import lombok.*;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * <p>
 * 为了通过 webflux 的参数类型校验，需要返回该对象，并传入真实的返回值。
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DownloadMono extends Mono<Void> implements ValueContainer {

    @Getter
    private Object value;

    @Override
    public void subscribe(@NonNull CoreSubscriber<? super Void> actual) {
        //can not be called
    }

    public static @NonNull DownloadMono empty() {
        return new DownloadMono();
    }

    public static DownloadMono value(Object value) {
        return new DownloadMono(value);
    }
}
