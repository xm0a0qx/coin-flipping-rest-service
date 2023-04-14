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
    private long headsCount;
    private long tailsCount;
    private static final String HEAD = "HEAD";
    private static final String TAILS = "TAILS";

    public static OutcomeData generateOutcome(List<Coin> flippedCoins) {
        long heads = countCoinSites(flippedCoins, CoinSites.HEAD.name());
        long tails = countCoinSites(flippedCoins, CoinSites.TAILS.name());
        return new OutcomeData(flippedCoins, decide(heads, tails), heads, tails);
    }

    private static String decide(long heads,
                                 long tails) {
        return heads >= tails
                ? HEAD
                : TAILS;
    }

    private static long countCoinSites(List<Coin> flippedCoins,
                                       String coinSite) {
        return flippedCoins.stream()
                .filter(coin -> coin.coinSite().equals(coinSite))
                .count();
    }
}
