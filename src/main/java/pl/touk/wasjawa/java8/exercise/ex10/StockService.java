package pl.touk.wasjawa.java8.exercise.ex10;

import pl.touk.wasjawa.java8.exercise.common.stocks.Stock;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class StockService {

	public BigDecimalStats stocksStats(List<Stock> stocks) {
//        BigDecimal min = null;
//        BigDecimal max = null;
//        BigDecimal sum = BigDecimal.ZERO;
//        BigInteger count = BigInteger.ZERO;
//        for (Stock stock : stocks) {
//            if (min == null || min.compareTo(stock.getPrice()) > 0) {
//                min = stock.getPrice();
//            }
//            if (max == null || max.compareTo(stock.getPrice()) < 0) {
//                max = stock.getPrice();
//            }
//            sum = sum.add(stock.getPrice());
//            count = count.add(BigInteger.ONE);
//        }
//        BigDecimal avg = (BigInteger.ZERO.compareTo(count) == 0) ? BigDecimal.ZERO : sum.divide(new BigDecimal(count), RoundingMode.HALF_DOWN);
//        return new BigDecimalStats(Optional.ofNullable(min), Optional.ofNullable(max), sum, avg, count);

		return stocks.stream().collect(new BigDecimalStatsCollector());
	}

	public static class BigDecimalStatsCollector implements Collector<Stock, Acc, BigDecimalStats> {

		@Override public Supplier<Acc> supplier() {
			return Acc::new;
		}
		@Override public BiConsumer<Acc, Stock> accumulator() {
			return Acc::accumulate;
		}
		@Override public BinaryOperator<Acc> combiner() {
			return (first, second) -> first.add(second);
		}
		@Override public Function<Acc, BigDecimalStats> finisher() {
			return Acc::finish;
		}
		@Override public Set<Characteristics> characteristics() {
			return EnumSet.of(Characteristics.UNORDERED);
		}
	}

	public static class Acc {

		private Optional<BigDecimal> min = Optional.empty();
		private Optional<BigDecimal> max = Optional.empty();
		private BigDecimal sum = BigDecimal.ZERO;
		private BigInteger count = BigInteger.ZERO;

		public void accumulate(Stock stock) {
			BigDecimal price = stock.getPrice();
			min = Optional.of(price.min(min.orElse(price)));
			max = Optional.of(price.max(max.orElse(price)));
			sum = sum.add(stock.getPrice());
			count = count.add(BigInteger.ONE);
		}

		public Acc add(Acc other) {
			min = Stream.of(min, other.min)
					.filter(Optional::isPresent)
					.map(Optional::get)
					.min((l, r) -> l.compareTo(r));
			max = Stream.of(max, other.max)
					.filter(Optional::isPresent)
					.map(Optional::get)
					.max((l, r) -> l.compareTo(r));
			sum = sum.add(other.sum);
			count = count.add(other.count);
			return this;
		}

		public BigDecimalStats finish() {
			return new BigDecimalStats(min, max, sum, sum.divide(new BigDecimal(count.max(BigInteger.ONE))), count);
		}
	}
}
