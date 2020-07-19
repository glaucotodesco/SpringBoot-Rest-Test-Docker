package com.example.dockersampler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@ExtendWith(SpringExtension.class)
@WebMvcTest(MyController.class)    
public class MyControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void  hello() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/hello");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Hello", result.getResponse().getContentAsString());
    }

        @Test
    public void  helloWithPathVar() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/hello/Glauco");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Hello: GLAUCO", result.getResponse().getContentAsString());
    }

    @Test
    public void  helloWithParam() throws Exception{

        RequestBuilder request = MockMvcRequestBuilders.get("/hello2?name=Glauco");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Hello: GLAUCO", result.getResponse().getContentAsString());
    }

}
    