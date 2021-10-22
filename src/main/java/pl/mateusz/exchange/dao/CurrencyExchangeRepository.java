package pl.mateusz.exchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mateusz.exchange.model.CurrencyExchangeEntity;
import pl.mateusz.exchange.model.values.Currency;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeEntity, Long> {

//    CurrencyExchangeEntity findFirstByCurrencyFromAndCurrencyTo(String from, String to);

    CurrencyExchangeEntity findByCurrencyFromAndAndCurrencyTo(Currency from, Currency to);

}
