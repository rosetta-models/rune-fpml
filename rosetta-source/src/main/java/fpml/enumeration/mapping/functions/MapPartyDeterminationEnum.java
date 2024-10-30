package fpml.enumeration.mapping.functions;

import cdm.observable.asset.PartyDeterminationEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapPartyDeterminationEnum.MapPartyDeterminationEnumDefault.class)
public abstract class MapPartyDeterminationEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public PartyDeterminationEnum evaluate(String value) {
		PartyDeterminationEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract PartyDeterminationEnum doEvaluate(String value);

	public static class MapPartyDeterminationEnumDefault extends MapPartyDeterminationEnum {
		@Override
		protected PartyDeterminationEnum doEvaluate(String value) {
			PartyDeterminationEnum result = null;
			return assignOutput(result, value);
		}
		
		protected PartyDeterminationEnum assignOutput(PartyDeterminationEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("ExercisingParty"), CardinalityOperator.All).get()) {
				result = PartyDeterminationEnum.EXERCISING_PARTY;
			} else if (areEqual(switchArgument, MapperS.of("NonExercisingParty"), CardinalityOperator.All).get()) {
				result = PartyDeterminationEnum.NON_EXERCISING_PARTY;
			} else if (areEqual(switchArgument, MapperS.of("AsSpecifiedInMasterAgreement"), CardinalityOperator.All).get()) {
				result = PartyDeterminationEnum.AS_SPECIFIED_IN_MASTER_AGREEMENT;
			} else if (areEqual(switchArgument, MapperS.of("AsSpecifiedInStandardTermsSupplement"), CardinalityOperator.All).get()) {
				result = PartyDeterminationEnum.AS_SPECIFIED_IN_STANDARD_TERMS_SUPPLEMENT;
			} else if (areEqual(switchArgument, MapperS.of("Both"), CardinalityOperator.All).get()) {
				result = PartyDeterminationEnum.BOTH;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
