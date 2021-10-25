package pl.mateusz.exchange.model.dto;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyExchangeDTO that = (CurrencyExchangeDTO) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
