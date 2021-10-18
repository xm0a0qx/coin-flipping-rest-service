package com.sample.coinflippingrestservice;

import com.sample.coinflippingrestservice.coinflipper.controller.CoinFlipperController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CoinFlipperController.class)
@AutoConfigureRestDocs(outputDir = "build/snippets")
class CoinFlippingWebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnSingleFlipResult() throws Exception {
        this.mockMvc.perform(get("/v1/flips/1")).andDo(print()).andExpect(status().isOk());
    }
}
