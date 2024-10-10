package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculationFromObservationChoiceSequence;
import fpml.confirmation.validation.CalculationFromObservationChoiceSequenceTypeFormatValidator;
import fpml.confirmation.validation.CalculationFromObservationChoiceSequenceValidator;
import fpml.confirmation.validation.exists.CalculationFromObservationChoiceSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CalculationFromObservationChoiceSequence.class)
public class CalculationFromObservationChoiceSequenceMeta implements RosettaMetaData<CalculationFromObservationChoiceSequence> {

	@Override
	public List<Validator<? super CalculationFromObservationChoiceSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculationFromObservationChoiceSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CalculationFromObservationChoiceSequence> validator() {
		return new CalculationFromObservationChoiceSequenceValidator();
	}

	@Override
	public Validator<? super CalculationFromObservationChoiceSequence> typeFormatValidator() {
		return new CalculationFromObservationChoiceSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationFromObservationChoiceSequence, Set<String>> onlyExistsValidator() {
		return new CalculationFromObservationChoiceSequenceOnlyExistsValidator();
	}
}
