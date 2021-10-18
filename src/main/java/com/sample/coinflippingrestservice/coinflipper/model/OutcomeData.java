package com.sample.coinflippingrestservice.coinflipper.model;

import com.sample.coinflippingrestservice.coinflipper.CoinSites;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class OutcomeData {
    private List<Coin> flippedCoins;
    private String decision;
    private long heads;
    private long tails;
    private static final String MOVE = "MOVE FORWARD";
    private static final String HOLD = "HOLD";

    public static OutcomeData generateOutcome(List<Coin> flippedCoins) {
        long heads = countCoinSites(flippedCoins, CoinSites.HEAD.name());
        long tails = countCoinSites(flippedCoins, CoinSites.TAILS.name());
        return new OutcomeData(flippedCoins, decide(heads, tails), heads, tails);
    }

    private static String decide(long heads,
                                 long tails) {
        return heads >= tails
                ? MOVE
                : HOLD;
    }

    private static long countCoinSites(List<Coin> flippedCoins,
                                       String coinSite) {
        return flippedCoins.stream()
                .filter(coin -> coin.coinSite().equals(coinSite))
                .count();
    }
}
