package pl.mateusz.exchange.api;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.mateusz.exchange.model.dto.CurrencyExchange;
import pl.mateusz.exchange.model.values.Currency;
import pl.mateusz.exchange.service.CurrencyExchangeService;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class CurrencyExchangeControllerTest{

    private MockMvc mvc;

    @Mock
    private CurrencyExchangeService currencyExchangeService;

    @InjectMocks
    private CurrencyExchangeController currencyExchangeController;

    @Test
    public void printHello() {
        Assertions.assertTrue(currencyExchangeController.hello().equals("hello"));
    }

    @Test
    public void lala() throws Exception {
    //given
//        given(currencyExchangeService.exchangeCurrency(
//                new UserInputObject(BigDecimal.valueOf(100), Currency.PLN,Currency.EUR)))
//                .willReturn(CurrencyExchange.of(BigDecimal.valueOf(22)));

    //when
        MockHttpServletResponse response = mvc.perform(
                get("/currency-exchange"))
                .andReturn().getResponse();

    //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());


    }

    @Test
    public void cos() {
        //given
        CurrencyExchange currencyExchange = CurrencyExchange.of(BigDecimal.valueOf(22));
        //when
        Mockito.when(
                currencyExchangeController.createFromParameters(BigDecimal.valueOf(100), Currency.PLN,Currency.EUR))
                .thenReturn(currencyExchange);
        //then
       assertThat(currencyExchangeController.createFromParameters(BigDecimal.valueOf(100), Currency.PLN,Currency.EUR)
                .getResult().equals(currencyExchange.getResult()));
    }
}
