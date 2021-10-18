package com.sample.coinflippingrestservice.coinflipper.service;

import com.sample.coinflippingrestservice.coinflipper.CoinSites;
import com.sample.coinflippingrestservice.coinflipper.model.Coin;

import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.IntStream;

public record CoinFlipper(int times, boolean isOverLimitAllowed) {
    private static final int LIMIT = 100;
    private static final AtomicLong counter = new AtomicLong();
    private static final Function<Boolean, Coin> coinFlippingFunction = coinSide -> coinSide.equals(true)
            ? new Coin(counter.incrementAndGet(), CoinSites.HEAD.name())
            : new Coin(counter.incrementAndGet(), CoinSites.TAILS.name());

    public List<Coin> flip() {
        return IntStream.range(0, getLimit())
                .mapToObj(index -> coinFlippingFunction.apply(isHead()))
                .toList();
    }

    private int getLimit() {
        if (isOverLimitAllowed) {
            return times;
        } else {
            return times <= LIMIT ? times : LIMIT;
        }

    }

    private boolean isHead() {
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextBoolean();
    }
}
