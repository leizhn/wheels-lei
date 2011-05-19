package com.tinfochina.infra.message;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.autonavi.infra.http.client.impl.HttpTemplate;
import com.autonavi.infra.utils.sms.impl.AnShortMessenger;

public class AutonaviShortMessengerTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSend() {
        AnShortMessenger ansm = new AnShortMessenger();
        ansm.setHttpOperation(new HttpTemplate());
        ansm.setPhoneNumbers(Arrays.asList(new String[]{
                "18601215767"
        }));
        ansm.setServiceUrl("http://www.findpath.net:82/smmp/servletsendmoremsg.do");
        ansm.setName("tinfo243");
        ansm.setPassword("123456");
        ansm.send("莎士比亚是哪个大学毕业的");
        ansm.send("which school ...?");
        assertTrue("end...", true);
    }

}
