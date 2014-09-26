package pl.touk.wasjawa.java8.exercise.ex03;

import pl.touk.wasjawa.java8.exercise.common.stocks.Stock;

import java.util.List;
import java.util.stream.Collectors;

public class StockService {
    public String companyNames(List<Stock> stocks) {
//	    StringBuilder sb = new StringBuilder("[");
//	    for (Stock stock : stocks) {
//		    if (sb.length() > 1) {
//			    sb.append(", ");
//		    }
//		    sb.append(stock.getCompanyName());
//	    }
//	    sb.append("]");
//	    return sb.toString();

	    return stocks.stream()
			    .map(Stock::getCompanyName)
	            .collect(Collectors.joining(", ", "[", "]"));
    }

}
