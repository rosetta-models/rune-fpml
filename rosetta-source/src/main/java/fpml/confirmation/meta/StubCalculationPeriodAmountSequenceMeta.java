package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.StubCalculationPeriodAmountSequence;
import fpml.confirmation.validation.StubCalculationPeriodAmountSequenceTypeFormatValidator;
import fpml.confirmation.validation.StubCalculationPeriodAmountSequenceValidator;
import fpml.confirmation.validation.exists.StubCalculationPeriodAmountSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=StubCalculationPeriodAmountSequence.class)
public class StubCalculationPeriodAmountSequenceMeta implements RosettaMetaData<StubCalculationPeriodAmountSequence> {

	@Override
	public List<Validator<? super StubCalculationPeriodAmountSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super StubCalculationPeriodAmountSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super StubCalculationPeriodAmountSequence> validator() {
		return new StubCalculationPeriodAmountSequenceValidator();
	}

	@Override
	public Validator<? super StubCalculationPeriodAmountSequence> typeFormatValidator() {
		return new StubCalculationPeriodAmountSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StubCalculationPeriodAmountSequence, Set<String>> onlyExistsValidator() {
		return new StubCalculationPeriodAmountSequenceOnlyExistsValidator();
	}
}
