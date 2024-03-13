package com.zyc.download4j.core.write;

import lombok.Getter;

/**
 * @author StevenZhang
 * @date 2023/09/27
 * 进度类。
 */
@Getter
public class Progress {

    private final Long total;

    private long current;

    public Progress(Long total) {
        this.total = total;
    }

    public boolean hasTotal() {
        return total != null && total > 0;
    }

    public void update(long increase) {
        if (increase <= 0) {
            return;
        }
        current += increase;
    }

    public Progress freeze() {
        Progress progress = new Progress(total);
        progress.current = current;
        return progress;
    }
}
