package fpml.enumeration.mapping.functions;

import cdm.base.staticdata.party.EntityTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapEntityTypeEnum.MapEntityTypeEnumDefault.class)
public abstract class MapEntityTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public EntityTypeEnum evaluate(String value) {
		EntityTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract EntityTypeEnum doEvaluate(String value);

	public static class MapEntityTypeEnumDefault extends MapEntityTypeEnum {
		@Override
		protected EntityTypeEnum doEvaluate(String value) {
			EntityTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected EntityTypeEnum assignOutput(EntityTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Asian"), CardinalityOperator.All).get()) {
				result = EntityTypeEnum.ASIAN;
			} else if (areEqual(switchArgument, MapperS.of("AustralianAndNewZealand"), CardinalityOperator.All).get()) {
				result = EntityTypeEnum.AUSTRALIAN_AND_NEW_ZEALAND;
			} else if (areEqual(switchArgument, MapperS.of("EuropeanEmergingMarket"), CardinalityOperator.All).get()) {
				result = EntityTypeEnum.EUROPEAN_EMERGING_MARKETS;
			} else if (areEqual(switchArgument, MapperS.of("Japanese"), CardinalityOperator.All).get()) {
				result = EntityTypeEnum.JAPANESE;
			} else if (areEqual(switchArgument, MapperS.of("NorthAmericanHighYield"), CardinalityOperator.All).get()) {
				result = EntityTypeEnum.NORTH_AMERICAN_HIGH_YIELD;
			} else if (areEqual(switchArgument, MapperS.of("NorthAmericanInsurance"), CardinalityOperator.All).get()) {
				result = EntityTypeEnum.NORTH_AMERICAN_INSURANCE;
			} else if (areEqual(switchArgument, MapperS.of("NorthAmericanInvestmentGrade"), CardinalityOperator.All).get()) {
				result = EntityTypeEnum.NORTH_AMERICAN_INVESTMENT_GRADE;
			} else if (areEqual(switchArgument, MapperS.of("Singaporean"), CardinalityOperator.All).get()) {
				result = EntityTypeEnum.SINGAPOREAN;
			} else if (areEqual(switchArgument, MapperS.of("WesternEuropean"), CardinalityOperator.All).get()) {
				result = EntityTypeEnum.WESTERN_EUROPEAN;
			} else if (areEqual(switchArgument, MapperS.of("WesternEuropeanInsurance"), CardinalityOperator.All).get()) {
				result = EntityTypeEnum.WESTERN_EUROPEAN_INSURANCE;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
