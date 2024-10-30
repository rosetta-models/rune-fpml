package fpml.enumeration.mapping.functions;

import cdm.legaldocumentation.common.LegalAgreementPublisherEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapLegalAgreementPublisherEnum.MapLegalAgreementPublisherEnumDefault.class)
public abstract class MapLegalAgreementPublisherEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public LegalAgreementPublisherEnum evaluate(String value) {
		LegalAgreementPublisherEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract LegalAgreementPublisherEnum doEvaluate(String value);

	public static class MapLegalAgreementPublisherEnumDefault extends MapLegalAgreementPublisherEnum {
		@Override
		protected LegalAgreementPublisherEnum doEvaluate(String value) {
			LegalAgreementPublisherEnum result = null;
			return assignOutput(result, value);
		}
		
		protected LegalAgreementPublisherEnum assignOutput(LegalAgreementPublisherEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("AFB"), CardinalityOperator.All).get()) {
				result = LegalAgreementPublisherEnum.AFB;
			} else if (areEqual(switchArgument, MapperS.of("ISDA"), CardinalityOperator.All).get()) {
				result = LegalAgreementPublisherEnum.ISDA;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
