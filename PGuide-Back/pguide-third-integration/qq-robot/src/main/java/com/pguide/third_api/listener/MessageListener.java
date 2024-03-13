package com.pguide.third_api.listener;

import com.alibaba.fastjson.JSONObject;
import com.pguide.third_api.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import love.forte.simbot.annotation.OnGroup;
import love.forte.simbot.annotation.OnPrivate;
import love.forte.simbot.api.message.Reply;
import love.forte.simbot.api.message.ReplyAble;
import love.forte.simbot.api.message.events.GroupMsg;
import love.forte.simbot.api.message.events.MessageGet;
import love.forte.simbot.api.message.events.PrivateMsg;
import love.forte.simbot.api.sender.MsgSender;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author sinahar
 * @version 1.0
 * @description: TODO 消息监听
 * @date 2023/8/15 21:28
 */
@Component
@Slf4j
public class MessageListener {



    // TODO chatgpt的接口
    static final String URL = "http://api.qingyunke.com/api.php";

    /**
     * 监听私聊消息
     *
     * @param privateMsg
     * @param sender
     */
    @OnPrivate
    public void privateMsg(PrivateMsg privateMsg, MsgSender sender) {
        // 智能聊天
        sendMsg(privateMsg, sender, false);
    }

    @OnGroup
    public ReplyAble groupMsg(GroupMsg groupMsg, MsgSender sender) {
        // 默认关闭群聊模式，需要的话把注释去掉
        // return sendMsg(groupMsg,sender,true);
        return null;
    }

    /**
     * 封装智能聊天
     *
     * @param commonMsg
     * @param sender
     * @param group
     * @return
     */
    private ReplyAble sendMsg(MessageGet commonMsg, MsgSender sender, boolean group) {
        log.info("智能聊天~~~,接收信息:qq={},msg={}", commonMsg.getAccountInfo().getAccountCode(),
                commonMsg.getMsgContent().getMsg());
        // 通过get方法调用聊天接口
        final String result = HttpUtil.get(URL.concat("?key=free&appid=0&msg="))
                .concat(commonMsg.getMsgContent().getMsg());
        if (!StringUtils.isEmpty(result)) {
            final JSONObject jsonObject = JSONObject.parseObject(result);
            if (jsonObject.getInteger("result") == 0 && !StringUtils
                    .isEmpty(jsonObject.getString("content"))) {
                final String msg = jsonObject.getString("content").replace("{br}", "\n");
                log.info("智能聊天~~~,接收信息:qq={},msg={}", commonMsg.getAccountInfo().getAccountCode(), msg);
                // 发送群消息
                if (group) {
                    // 参数1:回复的消息,参数2:是否@当事人
                    return Reply.reply(msg, true);
                }
                // 发送私聊消息
                sender.SENDER.sendPrivateMsg(commonMsg, msg);
            }
        }
        return null;
    }
}
