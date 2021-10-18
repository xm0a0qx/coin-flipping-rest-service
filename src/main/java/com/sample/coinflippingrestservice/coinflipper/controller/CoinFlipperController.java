package com.sample.coinflippingrestservice.coinflipper.controller;

import com.sample.coinflippingrestservice.coinflipper.model.Coin;
import com.sample.coinflippingrestservice.coinflipper.model.OutcomeData;
import com.sample.coinflippingrestservice.coinflipper.service.CoinFlippingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/flips")
public record CoinFlipperController(CoinFlippingService coinFlippingService) {

    @GetMapping("/{times}")
    @ResponseStatus(HttpStatus.OK)
    public List<Coin> flip(@PathVariable int times) {
        return coinFlippingService.flipCoin(times, true);
    }

    @GetMapping("/{times}/total")
    @ResponseStatus(HttpStatus.OK)
    public OutcomeData flipReport(@PathVariable int times) {
        return coinFlippingService.getOutcome(coinFlippingService.flipCoin(times, false));
    }
}
