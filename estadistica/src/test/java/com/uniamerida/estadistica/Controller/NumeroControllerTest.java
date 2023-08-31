package com.uniamerida.estadistica.Controller;

import com.uniamerida.estadistica.Service.NumeroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(NumeroController.class)
public class NumeroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NumeroService numeroService;

    @BeforeEach
    public void setUp() {}

    @Test
    public void testAdicionarNumero() throws Exception {
        mockMvc.perform(post("/numeros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"valor\": 10.0}"))
                .andExpect(status().isOk());
    }


}
