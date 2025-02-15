package io.chovy.rush.common.lang.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

public class IdUtils {
    public static long newSnowflakeId() {
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        return snowflake.nextId();
    }

    public static String newUUID() {
        return IdUtil.simpleUUID();
    }
}
