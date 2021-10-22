//package pl.mateusz.exchange.service;
//
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringRunner;
//import pl.mateusz.exchange.dao.CurrencyExchangeRepository;
//import pl.mateusz.exchange.model.CurrencyExchange;
//
//import java.math.BigDecimal;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//public class CurrencyExchangeServiceTest {
//
//    private final CurrencyExchangeRepository repository = mock(CurrencyExchangeRepository.class);
//    private CurrencyExchangeService currencyExchangeService;
//
//    @Before
//    public void setup() {
//        currencyExchangeService = new CurrencyExchangeService(repository);
//    }
//
//    @After
//    public void end() {
//        currencyExchangeService = null;
//    }
//
//    @Test
//    public void checkIfExchangeIsCorrectWhenAssertingTwoSameObjects() {
//        when(repository.findFirstByCurrencyFromAndCurrencyTo("PLN", "USD"))
//                .thenReturn(
//                        new CurrencyExchange("PLN", "USD", BigDecimal.valueOf(4))
//                );
//        Assert.assertEquals(currencyExchangeService.exchangeCurrency("PLN", "USD"),
//                new CurrencyExchange("PLN", "USD", BigDecimal.valueOf(4)));
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void whenExceptionThrown_thenExpectationSatisfied() {
//        CurrencyExchange currencyExchange = null;
//        currencyExchange.getCurrencyMultiplier();
//    }
//}
