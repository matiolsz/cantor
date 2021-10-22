package pl.mateusz.exchange.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class CurrencyExchangeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String currencyFrom;

    private String currencyTo;

    private Double currencyMultiplier;

    public CurrencyExchangeEntity(String currencyFrom, String currencyTo, Double currencyMultiplier) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.currencyMultiplier = currencyMultiplier;
    }

    public CurrencyExchangeEntity() {

    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public Double getCurrencyMultiplier() {
        return currencyMultiplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyExchangeEntity that = (CurrencyExchangeEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(currencyFrom, that.currencyFrom) && Objects.equals(currencyTo, that.currencyTo) && Objects.equals(currencyMultiplier, that.currencyMultiplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currencyFrom, currencyTo, currencyMultiplier);
    }
}
