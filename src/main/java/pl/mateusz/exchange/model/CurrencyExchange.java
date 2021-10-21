package pl.mateusz.currencyexchangeservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class CurrencyExchange { //FIXME equals/hashcode wywalic settery

    //FIXME
    @Id
    private Long id;

    @Column(name = "currency_from")//FIXME
    private String from;

    @Column(name = "currency_to")//FIXME
    private String to;

    private BigDecimal conversionMultiple;//FIXME co to za nazwa?

    private String environment;

    public CurrencyExchange(String from, String to, BigDecimal conversionMultiple, String environment) {
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.environment = environment;
    }

    public String getEnvironment() {
        return environment;
    }

    public Long getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyExchange that = (CurrencyExchange) o;
        return Objects.equals(id, that.id) && Objects.equals(from, that.from) && Objects.equals(to, that.to) && Objects.equals(conversionMultiple, that.conversionMultiple) && Objects.equals(environment, that.environment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, conversionMultiple, environment);
    }
}
