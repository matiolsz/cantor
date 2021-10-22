package pl.mateusz.exchange.service;

import org.springframework.stereotype.Service;
import pl.mateusz.exchange.dao.CurrencyExchangeRepository;
import pl.mateusz.exchange.model.CurrencyExchangeEntity;
import pl.mateusz.exchange.model.dto.CurrencyExchangeDTO;

import javax.persistence.EntityNotFoundException;


@Service
public class CurrencyExchangeService {

    private final CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchangeService(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    public CurrencyExchangeDTO exchangeCurrency(Double amount, String from, String to) {
        CurrencyExchangeEntity currencyExchangeEntity = currencyExchangeRepository.findByCurrencyFromAndAndCurrencyTo(from, to);
        if (currencyExchangeEntity == null) {
            throw new EntityNotFoundException("This currency exchange is not possible.");
        }
        return CurrencyExchangeDTO.giveMeCurrencyExchangeDTO(currencyExchangeEntity.getCurrencyMultiplier()*amount);

    }
}
