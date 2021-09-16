package com.practice.moneytransferapp.integrationtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
public class AccountController_IT {

    private final String ENDPOINT = "/api/account/create";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldCreateAccountWithValidInfo () throws Exception {

        String payload = "{\n" +
                "  \"first_name\": \"Abeba\",\n" +
                "  \"middle_name\": \"Dessalegn\",\n" +
                "  \"last_name\": \"AbreshZget\",\n" +
                "  \"phone_number\": \"0933445566\",\n" +
                "  \"birth_date\": \"2000-01-01\",\n" +
                "  \"pin\": 1234,\n" +
                "  \"email\": \"abebadess@gmail.com\"\n" +
                "}";

        mockMvc.perform(
                post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload)
        )
                .andDo(print())
                .andExpect(status().isOk());
//                .andExpect(content().json("{\n" +
//                                "  \"first_name\": \"Abeba\",\n" +
//                                "  \"middle_name\": \"Dessalegn\",\n" +
//                                "  \"last_name\": \"AbreshZget\",\n" +
//                                "  \"phone_number\": \"0933445566\",\n" +
//                                "  \"pin\": 1234,\n" +
//                                "  \"email\": \"abebadess@gmail.com\"\n" +
//                                "}"))
     //           .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));

    }


    @Test
    public void shouldReturnNullBecauseOfTooSmallAge() throws Exception {
        String data = "{\n" +
                "  \"first_name\": \"Abeba\",\n" +
                "  \"middle_name\": \"Dessalegn\",\n" +
                "  \"last_name\": \"AbreshZget\",\n" +
                "  \"phone_number\": \"0933445566\",\n" +
                "  \"birth_date\": \"2015-01-01\",\n" +
                "  \"pin\": 1234,\n" +
                "  \"email\": \"abebadess@gmail.com\"\n" +
                "}";

        mockMvc.perform(
                post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(data)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) contentType(MediaType.APPLICATION_JSON));
                //.andExpect(content().json())
    }
}
