package pl.mateusz.exchange.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import pl.mateusz.exchange.model.CurrencyExchangeEntity;
import pl.mateusz.exchange.model.dto.CurrencyExchange;
import pl.mateusz.exchange.model.dto.UserInputObject;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static pl.mateusz.exchange.model.values.Currency.PLN;
import static pl.mateusz.exchange.model.values.Currency.USD;

@RunWith(SpringRunner.class)
public class CurrencyExchangeServiceTest {

    private final CurrencyExchangeRepository repository = mock(CurrencyExchangeRepository.class);
    private CurrencyExchangeService currencyExchangeService;

    @Before
    public void setup() {
        currencyExchangeService = new CurrencyExchangeService(repository);
    }

    @After
    public void end() {
        currencyExchangeService = null;
    }

    @Test
    public void checkIfExchangeIsCorrectWhenAssertingTwoSameObjects() {
        when(repository.findByCurrencyFromAndAndCurrencyTo(PLN, USD))
                .thenReturn(
                        new CurrencyExchangeEntity(PLN, USD, BigDecimal.valueOf(4))
                );
        Assert.assertEquals(currencyExchangeService.exchangeCurrency(new UserInputObject(BigDecimal.valueOf(100),PLN, USD)),
                new CurrencyExchangeEntity(PLN, USD, BigDecimal.valueOf(4)));
    }



}
