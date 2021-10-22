//package pl.mateusz.exchange.api;
//
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringRunner;
//import pl.mateusz.exchange.model.CurrencyExchange;
//import pl.mateusz.exchange.service.CurrencyExchangeService;
//
//import java.math.BigDecimal;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//public class CurrencyExchangeControllerTest {
//
//    private final CurrencyExchangeService service = mock(CurrencyExchangeService.class);
//    private CurrencyExchangeController currencyExchangeController;
//
//    @Before
//    public void setup() {
//        currencyExchangeController = new CurrencyExchangeController(service);
//    }
//
//    @After
//    public void end() {
//        currencyExchangeController = null;
//    }
//
//    @Test
//    public void checkIfPLNToUSDIsCorrect() {
//        when(service.exchangeCurrency("PLN", "USD"))
//                .thenReturn(
//                        new CurrencyExchange("PLN", "USD", BigDecimal.valueOf(4))
//                );
//        Assert.assertEquals(currencyExchangeController.retrieveCurrencyExchangeEntityWithValue("PLN", "USD"),
//                new CurrencyExchange("PLN", "USD", BigDecimal.valueOf(4)));
//    }
//
//
//}
