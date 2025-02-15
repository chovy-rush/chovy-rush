package io.chovy.rush.common.lang.utils;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IdUtilsTest {

    @Test
    public void newSnowflakeId() {
        long id = IdUtils.newSnowflakeId();
        System.out.println("snowflake id = " + id);
        assertTrue(id > 0);
    }

    @Test
    public void newUUIDTest() {
        String id = IdUtils.newUUID();
        System.out.println("uuid = " + id);
        assertTrue(id.length() > 0);
    }
}
