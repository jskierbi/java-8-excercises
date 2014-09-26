package pl.touk.wasjawa.java8.exercise.ex02;

import pl.touk.wasjawa.java8.exercise.common.stocks.Stock;

import java.math.BigDecimal;
import java.util.List;

public class StocksService {

    private static final BigDecimal EXPENSIVE_STOCK_LIMIT = BigDecimal.valueOf(100);

    public BigDecimal totalValueOfExpensiveStocks(List<Stock> stocks) {
//	    BigDecimal total = BigDecimal.ZERO;
//	    for (Stock stock : stocks) {
//		    if (EXPENSIVE_STOCK_LIMIT.compareTo(stock.getPrice()) < 0) {
//			    total = total.add(stock.getPrice());
//		    }
//	    }
//	    return total;

		return stocks.stream()
				.map(Stock::getPrice)
				.filter(p -> EXPENSIVE_STOCK_LIMIT.compareTo(p) < 0)
	            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
