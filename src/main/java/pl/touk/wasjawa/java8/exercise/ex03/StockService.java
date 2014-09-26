package pl.touk.wasjawa.java8.exercise.ex03;

import pl.touk.wasjawa.java8.exercise.common.stocks.Stock;

import java.util.List;
import java.util.stream.Collectors;

public class StockService {
    public String companyNames(List<Stock> stocks) {
	    return stocks.stream()
			    .map(Stock::getCompanyName)
	            .collect(Collectors.joining(", ", "[", "]"));
    }

}
