package pl.mateusz.exchange.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.mateusz.exchange.api.CurrencyExchangeController;
import pl.mateusz.exchange.model.CurrencyExchangeEntity;
import pl.mateusz.exchange.model.dto.CurrencyExchange;
import pl.mateusz.exchange.model.dto.UserInputObject;
import pl.mateusz.exchange.model.values.Currency;
import pl.mateusz.exchange.service.CurrencyExchangeService;

import java.math.BigDecimal;
import java.nio.charset.Charset;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.mateusz.exchange.model.values.Currency.EUR;
import static pl.mateusz.exchange.model.values.Currency.PLN;

@ExtendWith(MockitoExtension.class)
 class ControllerMockitoTest {

    @Mock
    private CurrencyExchangeService currencyExchangeService;

    @InjectMocks
    private CurrencyExchangeController currencyExchangeController;

    @BeforeEach
    void setMockOutput() {
        when(currencyExchangeService.exchangeCurrency(
                any()))
                .thenReturn(new CurrencyExchange(BigDecimal.valueOf(22.00)));
    }

    @Test
     void shouldReturnCorrectObjectWhenMethodIsCalled() {
        CurrencyExchange response = currencyExchangeController
                .createFromParameters(BigDecimal.valueOf(100), PLN, EUR);
        assertThat(response).hasFieldOrPropertyWithValue("result", BigDecimal.valueOf(22.00));
    }

}
