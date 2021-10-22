package pl.mateusz.exchange.model.dto;

import pl.mateusz.exchange.model.CurrencyExchangeEntity;

public class CurrencyExchangeDTO {

    final Double result;

    private CurrencyExchangeDTO(Double result) {
        this.result = result;
    }

    public static CurrencyExchangeDTO giveMeCurrencyExchangeDTO(Double result) {
        return new CurrencyExchangeDTO(result);
    }

    public Double getResult() {
        return result;
    }
}
