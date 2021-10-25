package pl.mateusz.exchange.service;

import org.springframework.stereotype.Service;
import pl.mateusz.exchange.model.CurrencyExchangeEntity;
import pl.mateusz.exchange.model.dto.CurrencyExchangeDTO;
import pl.mateusz.exchange.model.values.Currency;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;


@Service
public class CurrencyExchangeService {

    private final CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchangeService(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    public CurrencyExchangeDTO exchangeCurrency(BigDecimal amount, Currency from, Currency to) {
        CurrencyExchangeEntity currencyExchangeEntity = currencyExchangeRepository.findByCurrencyFromAndAndCurrencyTo(from, to);
        if (currencyExchangeEntity == null) {
            throw new EntityNotFoundException("This currency exchange is not possible.");
        }
        return CurrencyExchangeDTO.giveMeCurrencyExchangeDTO(currencyExchangeEntity.getCurrencyMultiplier().multiply(amount));

    }
}
