package com.tinfochina.infra.net.http.impl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.autonavi.infra.http.client.HTTPRequestMethod;
import com.autonavi.infra.http.client.impl.HttpTemplate;

public class HttpTemplateTest {

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
    public void testGetResultStringHTTPRequestMethod() {
        HttpTemplate ht= new HttpTemplate();
        ht.getResult("http://localhost:8080/TmpServer/Printer?x=1&y=2&z=3", null, HTTPRequestMethod.POST);
    }

}
