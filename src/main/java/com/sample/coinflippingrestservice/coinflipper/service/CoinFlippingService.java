package com.sample.coinflippingrestservice.coinflipper.service;

import com.sample.coinflippingrestservice.coinflipper.model.Coin;
import com.sample.coinflippingrestservice.coinflipper.model.OutcomeData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoinFlippingService {

    public List<Coin> flipCoin(int times, boolean isOverLimitAllowed) {
        return new CoinFlipper(times, isOverLimitAllowed).flip();
    }

    public OutcomeData getOutcome(List<Coin> flippedCoins) {
        return OutcomeData.generateOutcome(flippedCoins);
    }
}
