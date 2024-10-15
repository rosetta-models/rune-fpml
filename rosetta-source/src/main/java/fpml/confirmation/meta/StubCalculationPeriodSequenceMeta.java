package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.StubCalculationPeriodSequence;
import fpml.confirmation.validation.StubCalculationPeriodSequenceTypeFormatValidator;
import fpml.confirmation.validation.StubCalculationPeriodSequenceValidator;
import fpml.confirmation.validation.exists.StubCalculationPeriodSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=StubCalculationPeriodSequence.class)
public class StubCalculationPeriodSequenceMeta implements RosettaMetaData<StubCalculationPeriodSequence> {

	@Override
	public List<Validator<? super StubCalculationPeriodSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super StubCalculationPeriodSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super StubCalculationPeriodSequence> validator() {
		return new StubCalculationPeriodSequenceValidator();
	}

	@Override
	public Validator<? super StubCalculationPeriodSequence> typeFormatValidator() {
		return new StubCalculationPeriodSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StubCalculationPeriodSequence, Set<String>> onlyExistsValidator() {
		return new StubCalculationPeriodSequenceOnlyExistsValidator();
	}
}
