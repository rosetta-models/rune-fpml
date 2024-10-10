package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.Stub;
import fpml.confirmation.StubCalculationPeriod;
import fpml.confirmation.StubCalculationPeriodSequence;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class StubCalculationPeriodDeepPathUtil {
	public Stub chooseFinalStub(StubCalculationPeriod stubCalculationPeriod) {
		final MapperS<StubCalculationPeriodSequence> stubCalculationPeriodSequence = MapperS.of(stubCalculationPeriod).<StubCalculationPeriodSequence>map("getStubCalculationPeriodSequence", _stubCalculationPeriod -> _stubCalculationPeriod.getStubCalculationPeriodSequence());
		if (exists(stubCalculationPeriodSequence).getOrDefault(false)) {
			return stubCalculationPeriodSequence.<Stub>map("getFinalStub", _stubCalculationPeriodSequence -> _stubCalculationPeriodSequence.getFinalStub()).get();
		}
		final MapperS<Stub> finalStub = MapperS.of(stubCalculationPeriod).<Stub>map("getFinalStub", _stubCalculationPeriod -> _stubCalculationPeriod.getFinalStub());
		if (exists(finalStub).getOrDefault(false)) {
			return finalStub.get();
		}
		return null;
	}
	
}
