package fpml.enumeration.mapping.functions;

import cdm.observable.asset.CreditRatingAgencyEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapCreditRatingAgencyEnum.MapCreditRatingAgencyEnumDefault.class)
public abstract class MapCreditRatingAgencyEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public CreditRatingAgencyEnum evaluate(String value) {
		CreditRatingAgencyEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract CreditRatingAgencyEnum doEvaluate(String value);

	public static class MapCreditRatingAgencyEnumDefault extends MapCreditRatingAgencyEnum {
		@Override
		protected CreditRatingAgencyEnum doEvaluate(String value) {
			CreditRatingAgencyEnum result = null;
			return assignOutput(result, value);
		}
		
		protected CreditRatingAgencyEnum assignOutput(CreditRatingAgencyEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("AMBest"), CardinalityOperator.All).get()) {
				result = CreditRatingAgencyEnum.AM_BEST;
			} else if (areEqual(switchArgument, MapperS.of("CBRS"), CardinalityOperator.All).get()) {
				result = CreditRatingAgencyEnum.CBRS;
			} else if (areEqual(switchArgument, MapperS.of("DBRS"), CardinalityOperator.All).get()) {
				result = CreditRatingAgencyEnum.DBRS;
			} else if (areEqual(switchArgument, MapperS.of("Fitch"), CardinalityOperator.All).get()) {
				result = CreditRatingAgencyEnum.FITCH;
			} else if (areEqual(switchArgument, MapperS.of("Japanagency"), CardinalityOperator.All).get()) {
				result = CreditRatingAgencyEnum.JAPANAGENCY;
			} else if (areEqual(switchArgument, MapperS.of("Moodys"), CardinalityOperator.All).get()) {
				result = CreditRatingAgencyEnum.MOODYS;
			} else if (areEqual(switchArgument, MapperS.of("RatingAndInvestmentInformation"), CardinalityOperator.All).get()) {
				result = CreditRatingAgencyEnum.RATING_AND_INVESTMENT_INFORMATION;
			} else if (areEqual(switchArgument, MapperS.of("StandardAndPoors"), CardinalityOperator.All).get()) {
				result = CreditRatingAgencyEnum.STANDARD_AND_POORS;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
