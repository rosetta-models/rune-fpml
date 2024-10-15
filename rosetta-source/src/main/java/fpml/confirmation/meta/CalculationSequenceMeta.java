package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculationSequence;
import fpml.confirmation.validation.CalculationSequenceTypeFormatValidator;
import fpml.confirmation.validation.CalculationSequenceValidator;
import fpml.confirmation.validation.exists.CalculationSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CalculationSequence.class)
public class CalculationSequenceMeta implements RosettaMetaData<CalculationSequence> {

	@Override
	public List<Validator<? super CalculationSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculationSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CalculationSequence> validator() {
		return new CalculationSequenceValidator();
	}

	@Override
	public Validator<? super CalculationSequence> typeFormatValidator() {
		return new CalculationSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationSequence, Set<String>> onlyExistsValidator() {
		return new CalculationSequenceOnlyExistsValidator();
	}
}
