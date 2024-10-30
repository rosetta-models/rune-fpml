package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InterestCalculationSequence;
import fpml.confirmation.validation.InterestCalculationSequenceTypeFormatValidator;
import fpml.confirmation.validation.InterestCalculationSequenceValidator;
import fpml.confirmation.validation.exists.InterestCalculationSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=InterestCalculationSequence.class)
public class InterestCalculationSequenceMeta implements RosettaMetaData<InterestCalculationSequence> {

	@Override
	public List<Validator<? super InterestCalculationSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestCalculationSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InterestCalculationSequence> validator() {
		return new InterestCalculationSequenceValidator();
	}

	@Override
	public Validator<? super InterestCalculationSequence> typeFormatValidator() {
		return new InterestCalculationSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestCalculationSequence, Set<String>> onlyExistsValidator() {
		return new InterestCalculationSequenceOnlyExistsValidator();
	}
}
