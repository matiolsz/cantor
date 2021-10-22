package pl.mateusz.exchange.service;

import org.springframework.stereotype.Service;
import pl.mateusz.exchange.dao.CurrencyExchangeRepository;
import pl.mateusz.exchange.model.CurrencyExchange;

import javax.persistence.EntityNotFoundException;


@Service
public class CurrencyExchangeService {

    private final CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchangeService(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    public CurrencyExchange exchangeCurrency(String from, String to) {
        CurrencyExchange currencyExchange = currencyExchangeRepository.findFirstByCurrencyFromAndCurrencyTo(from, to);
        if (currencyExchange == null) {
            throw new EntityNotFoundException("Unable to find data for " + from + " to " + to);
        }

        return new CurrencyExchange(from, to, currencyExchange.getCurrencyMultiplier());

    }
}
