package fpml.enumeration.mapping.functions;

import cdm.base.staticdata.asset.credit.ObligationCategoryEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(MapObligationCategoryEnum.MapObligationCategoryEnumDefault.class)
public abstract class MapObligationCategoryEnum implements RosettaFunction {

	/**
	* @param value 
	* @return result 
	*/
	public ObligationCategoryEnum evaluate(String value) {
		ObligationCategoryEnum result = doEvaluate(value);
		
		return result;
	}

	protected abstract ObligationCategoryEnum doEvaluate(String value);

	public static class MapObligationCategoryEnumDefault extends MapObligationCategoryEnum {
		@Override
		protected ObligationCategoryEnum doEvaluate(String value) {
			ObligationCategoryEnum result = null;
			return assignOutput(result, value);
		}
		
		protected ObligationCategoryEnum assignOutput(ObligationCategoryEnum result, String value) {
			final MapperS<String> switchArgument = MapperS.of(value);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("Payment"), CardinalityOperator.All).get()) {
				result = ObligationCategoryEnum.PAYMENT;
			} else if (areEqual(switchArgument, MapperS.of("BorrowedMoney"), CardinalityOperator.All).get()) {
				result = ObligationCategoryEnum.BORROWED_MONEY;
			} else if (areEqual(switchArgument, MapperS.of("ReferenceObligationsOnly"), CardinalityOperator.All).get()) {
				result = ObligationCategoryEnum.REFERENCE_OBLIGATIONS_ONLY;
			} else if (areEqual(switchArgument, MapperS.of("Bond"), CardinalityOperator.All).get()) {
				result = ObligationCategoryEnum.BOND;
			} else if (areEqual(switchArgument, MapperS.of("Loan"), CardinalityOperator.All).get()) {
				result = ObligationCategoryEnum.LOAN;
			} else if (areEqual(switchArgument, MapperS.of("BondOrLoan"), CardinalityOperator.All).get()) {
				result = ObligationCategoryEnum.BOND_OR_LOAN;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
