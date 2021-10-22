package pl.mateusz.exchange.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.mateusz.exchange.model.dto.CurrencyExchangeDTO;
import pl.mateusz.exchange.service.CurrencyExchangeService;

import javax.persistence.EntityNotFoundException;

@RestController
public class CurrencyExchangeController {

   private final CurrencyExchangeService currencyExchangeService;

   public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService) {
       this.currencyExchangeService = currencyExchangeService;
   }

    @GetMapping("/currency-exchange/{amount}/{from}/{to}")
    public CurrencyExchangeDTO retrieveCurrencyExchangeEntityWithValue(
            @PathVariable Double amount,
            @PathVariable String from,
            @PathVariable String to) {
    return currencyExchangeService.exchangeCurrency(amount,from, to);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handlyMyCustomException(EntityNotFoundException e) {
        return new ResponseEntity<>("Something happened: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
