package pl.mateusz.exchange.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class CurrencyExchange {

    @Id
    @GeneratedValue
    private Long id;

    private String currencyFrom;

    private String currencyTo;

    private BigDecimal currencyMultiplier;

    public CurrencyExchange(String currencyFrom, String currencyTo, BigDecimal currencyMultiplier) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.currencyMultiplier = currencyMultiplier;
    }

    public CurrencyExchange() {

    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public BigDecimal getCurrencyMultiplier() {
        return currencyMultiplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyExchange that = (CurrencyExchange) o;
        return Objects.equals(id, that.id) && Objects.equals(currencyFrom, that.currencyFrom) && Objects.equals(currencyTo, that.currencyTo) && Objects.equals(currencyMultiplier, that.currencyMultiplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currencyFrom, currencyTo, currencyMultiplier);
    }
}
