package com.zyc.listener;

import com.zyc.download4j.core.event.DownloadEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author StevenZhang
 * @date 2023/10/3
 * @description
 */
@Component
public class DownloadListener {

    @EventListener
    public void onDownloadEvent(DownloadEvent event) {
        //Instanceof / Switch-Case Mode Match....

    }

}
