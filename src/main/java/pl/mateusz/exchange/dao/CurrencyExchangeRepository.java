package pl.mateusz.exchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mateusz.exchange.model.CurrencyExchangeEntity;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeEntity, Long> {

//    CurrencyExchangeEntity findFirstByCurrencyFromAndCurrencyTo(String from, String to);

    CurrencyExchangeEntity findByCurrencyFromAndAndCurrencyTo(String from, String to);

}
