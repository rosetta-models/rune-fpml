package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TriggerRateObservationSequence0;
import fpml.confirmation.validation.TriggerRateObservationSequence0TypeFormatValidator;
import fpml.confirmation.validation.TriggerRateObservationSequence0Validator;
import fpml.confirmation.validation.exists.TriggerRateObservationSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TriggerRateObservationSequence0.class)
public class TriggerRateObservationSequence0Meta implements RosettaMetaData<TriggerRateObservationSequence0> {

	@Override
	public List<Validator<? super TriggerRateObservationSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TriggerRateObservationSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TriggerRateObservationSequence0> validator() {
		return new TriggerRateObservationSequence0Validator();
	}

	@Override
	public Validator<? super TriggerRateObservationSequence0> typeFormatValidator() {
		return new TriggerRateObservationSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TriggerRateObservationSequence0, Set<String>> onlyExistsValidator() {
		return new TriggerRateObservationSequence0OnlyExistsValidator();
	}
}
