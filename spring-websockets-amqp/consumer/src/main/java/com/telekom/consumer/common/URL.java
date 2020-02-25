package com.telekom.consumer.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * author: ElinaValieva on 02.02.2019
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class URL {
    public static final String TOPIC_PUBLIC = "/topic/greetings";
    public static final String APP = "/app";
    public static final String TOPIC = "/topic";
    public static final String END_POINT = "/gs-guide-websocket";
}
