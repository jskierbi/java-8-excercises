package pl.touk.wasjawa.java8.exercise.ex10;

import pl.touk.wasjawa.java8.exercise.common.stocks.Stock;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class StockService {
    public BigDecimalStats stocksStats(List<Stock> stocks) {
        BigDecimal min = null;
        BigDecimal max = null;
        BigDecimal sum = BigDecimal.ZERO;
        BigInteger count = BigInteger.ZERO;
        for (Stock stock : stocks) {
            if (min == null || min.compareTo(stock.getPrice()) > 0) {
                min = stock.getPrice();
            }
            if (max == null || max.compareTo(stock.getPrice()) < 0) {
                max = stock.getPrice();
            }
            sum = sum.add(stock.getPrice());
            count = count.add(BigInteger.ONE);
        }
        BigDecimal avg = (BigInteger.ZERO.compareTo(count) == 0) ? BigDecimal.ZERO : sum.divide(new BigDecimal(count), RoundingMode.HALF_DOWN);
        return new BigDecimalStats(Optional.ofNullable(min), Optional.ofNullable(max), sum, avg, count);
    }

	public static class BigDecimalStatsCollector implements Collector<Stock, Acc, BigDecimalStats> {

		@Override public Supplier<Acc> supplier() {
			return Acc::new;
		}
		@Override public BiConsumer<Acc, Stock> accumulator() {
			return (acc, stock) -> acc.accumulate(stock);
		}
		@Override public BinaryOperator<Acc> combiner() {
			return (first, second) -> first.add(second);
		}
		@Override public Function<Acc, BigDecimalStats> finisher() {
			return (acc) -> acc.finish();
		}
		@Override public Set<Characteristics> characteristics() {
			return EnumSet.of(Characteristics.UNORDERED);
		}
	}

	public static class Acc {

		private final Optional<BigDecimal> min;
		private final Optional<BigDecimal> max;
		private final BigDecimal sum;
		private final BigInteger count;

		public void accumulate(Stock stock) {
			// TODO min
			// TODO max
			sum += stock.getPrice();
			count += 1;
		}

		public Acc add(Acc second) {
			sum += second.sum;
			count += second.count;
		}

		public BigDecimalStats finish() {
			return new BigDecimalStats(Optional.of())
		}
	}
}
