package fpml.enumeration.mapping.functions;

import cdm.observable.asset.QuotationSideEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapQuotationSideEnum.MapQuotationSideEnumDefault.class)
public abstract class MapQuotationSideEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public QuotationSideEnum evaluate(String value) {
		QuotationSideEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract QuotationSideEnum doEvaluate(String value);

	public static class MapQuotationSideEnumDefault extends MapQuotationSideEnum {
		@Override
		protected QuotationSideEnum doEvaluate(String value) {
			QuotationSideEnum result = null;
			return assignOutput(result, value);
		}
		
		protected QuotationSideEnum assignOutput(QuotationSideEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Afternoon"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.AFTERNOON;
			} else if (areEqual(switchArgument, MapperS.of("Ask"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.ASK;
			} else if (areEqual(switchArgument, MapperS.of("Bid"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.BID;
			} else if (areEqual(switchArgument, MapperS.of("Closing"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.CLOSING;
			} else if (areEqual(switchArgument, MapperS.of("High"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.HIGH;
			} else if (areEqual(switchArgument, MapperS.of("Index"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.INDEX;
			} else if (areEqual(switchArgument, MapperS.of("MeanOfBidAndAsk"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.MEAN_OF_BID_AND_ASK;
			} else if (areEqual(switchArgument, MapperS.of("LocationalMarginal"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.LOCATIONAL_MARGINAL;
			} else if (areEqual(switchArgument, MapperS.of("Low"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.LOW;
			} else if (areEqual(switchArgument, MapperS.of("MarginalHourly"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.MARGINAL_HOURLY;
			} else if (areEqual(switchArgument, MapperS.of("MarketClearing"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.MARKET_CLEARING;
			} else if (areEqual(switchArgument, MapperS.of("MeanOfHighAndLow"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.MEAN_OF_HIGH_AND_LOW;
			} else if (areEqual(switchArgument, MapperS.of("Morning"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.MORNING;
			} else if (areEqual(switchArgument, MapperS.of("Official"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.OFFICIAL;
			} else if (areEqual(switchArgument, MapperS.of("Opening"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.OPENING;
			} else if (areEqual(switchArgument, MapperS.of("OSP"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.OSP;
			} else if (areEqual(switchArgument, MapperS.of("Settlement"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.SETTLEMENT;
			} else if (areEqual(switchArgument, MapperS.of("Spot"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.SPOT;
			} else if (areEqual(switchArgument, MapperS.of("Mid"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.MID;
			} else if (areEqual(switchArgument, MapperS.of("Midpoint"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.MID;
			} else if (areEqual(switchArgument, MapperS.of("NationalSingle"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.NATIONAL_SINGLE;
			} else if (areEqual(switchArgument, MapperS.of("WeightedAverage"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.WEIGHTED_AVERAGE;
			} else if (areEqual(switchArgument, MapperS.of("UnWeightedAverage"), CardinalityOperator.All).get()) {
				result = QuotationSideEnum.UN_WEIGHTED_AVERAGE;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
