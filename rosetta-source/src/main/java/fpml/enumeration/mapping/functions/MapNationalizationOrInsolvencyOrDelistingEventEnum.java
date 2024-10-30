package fpml.enumeration.mapping.functions;

import cdm.legaldocumentation.master.NationalizationOrInsolvencyOrDelistingEventEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapNationalizationOrInsolvencyOrDelistingEventEnum.MapNationalizationOrInsolvencyOrDelistingEventEnumDefault.class)
public abstract class MapNationalizationOrInsolvencyOrDelistingEventEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public NationalizationOrInsolvencyOrDelistingEventEnum evaluate(String value) {
		NationalizationOrInsolvencyOrDelistingEventEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract NationalizationOrInsolvencyOrDelistingEventEnum doEvaluate(String value);

	public static class MapNationalizationOrInsolvencyOrDelistingEventEnumDefault extends MapNationalizationOrInsolvencyOrDelistingEventEnum {
		@Override
		protected NationalizationOrInsolvencyOrDelistingEventEnum doEvaluate(String value) {
			NationalizationOrInsolvencyOrDelistingEventEnum result = null;
			return assignOutput(result, value);
		}
		
		protected NationalizationOrInsolvencyOrDelistingEventEnum assignOutput(NationalizationOrInsolvencyOrDelistingEventEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("NegotiatedCloseout"), CardinalityOperator.All).get()) {
				result = NationalizationOrInsolvencyOrDelistingEventEnum.NEGOTIATED_CLOSEOUT;
			} else if (areEqual(switchArgument, MapperS.of("CancellationAndPayment"), CardinalityOperator.All).get()) {
				result = NationalizationOrInsolvencyOrDelistingEventEnum.CANCELLATION_AND_PAYMENT;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
