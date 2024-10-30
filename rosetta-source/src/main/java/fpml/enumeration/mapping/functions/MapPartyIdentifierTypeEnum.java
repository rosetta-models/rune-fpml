package fpml.enumeration.mapping.functions;

import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapPartyIdentifierTypeEnum.MapPartyIdentifierTypeEnumDefault.class)
public abstract class MapPartyIdentifierTypeEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public PartyIdentifierTypeEnum evaluate(String value) {
		PartyIdentifierTypeEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract PartyIdentifierTypeEnum doEvaluate(String value);

	public static class MapPartyIdentifierTypeEnumDefault extends MapPartyIdentifierTypeEnum {
		@Override
		protected PartyIdentifierTypeEnum doEvaluate(String value) {
			PartyIdentifierTypeEnum result = null;
			return assignOutput(result, value);
		}
		
		protected PartyIdentifierTypeEnum assignOutput(PartyIdentifierTypeEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("http://www.fpml.org/coding-scheme/external/iso17442"), CardinalityOperator.All).get()) {
				result = PartyIdentifierTypeEnum.LEI;
			} else if (areEqual(switchArgument, MapperS.of("http://www.fpml.org/coding-scheme/external/iso9362"), CardinalityOperator.All).get()) {
				result = PartyIdentifierTypeEnum.BIC;
			} else if (areEqual(switchArgument, MapperS.of("http://www.fpml.org/coding-scheme/external/iso10383"), CardinalityOperator.All).get()) {
				result = PartyIdentifierTypeEnum.MIC;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
