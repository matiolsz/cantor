package pl.mateusz.exchange.model.dto;

import java.math.BigDecimal;

public class CurrencyExchange {

    final BigDecimal result;

    private CurrencyExchange(BigDecimal result) {
        this.result = result;
    }

    public static CurrencyExchange giveMeCurrencyExchangeDTO(BigDecimal result) {
        return new CurrencyExchange(result);
    }

    public BigDecimal getResult() {
        return result;
    }
}
