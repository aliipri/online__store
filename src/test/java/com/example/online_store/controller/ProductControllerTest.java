package com.example.online_store.controller;

import com.example.online_store.dto.ProductAvailabilityDTO;
import com.example.online_store.dto.ProductCheckAvailabilityDTO;
import com.example.online_store.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void testCheckAvailability() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        ProductCheckAvailabilityDTO requestDTO = new ProductCheckAvailabilityDTO();
        requestDTO.setProductId(1);
        requestDTO.setQuantity(10);

        ProductAvailabilityDTO responseDTO = new ProductAvailabilityDTO();
        responseDTO.setAvailable(true);

        when(productRepository.checkAvailability(any(), any())).thenReturn(true);

        mockMvc.perform(post("/api/products/checkAvailability")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"productId\":1,\"quantity\":10}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"available\":true}"));
    }
}
