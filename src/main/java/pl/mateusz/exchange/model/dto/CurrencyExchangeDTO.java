package pl.mateusz.exchange.model.dto;

import pl.mateusz.exchange.model.CurrencyExchangeEntity;

import java.math.BigDecimal;

public class CurrencyExchangeDTO {

    final BigDecimal result;

    private CurrencyExchangeDTO(BigDecimal result) {
        this.result = result;
    }

    public static CurrencyExchangeDTO giveMeCurrencyExchangeDTO(BigDecimal result) {
        return new CurrencyExchangeDTO(result);
    }

    public BigDecimal getResult() {
        return result;
    }
}
