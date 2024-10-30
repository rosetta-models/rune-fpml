package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TriggerRateObservationSequence1;
import fpml.confirmation.validation.TriggerRateObservationSequence1TypeFormatValidator;
import fpml.confirmation.validation.TriggerRateObservationSequence1Validator;
import fpml.confirmation.validation.exists.TriggerRateObservationSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TriggerRateObservationSequence1.class)
public class TriggerRateObservationSequence1Meta implements RosettaMetaData<TriggerRateObservationSequence1> {

	@Override
	public List<Validator<? super TriggerRateObservationSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TriggerRateObservationSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TriggerRateObservationSequence1> validator() {
		return new TriggerRateObservationSequence1Validator();
	}

	@Override
	public Validator<? super TriggerRateObservationSequence1> typeFormatValidator() {
		return new TriggerRateObservationSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TriggerRateObservationSequence1, Set<String>> onlyExistsValidator() {
		return new TriggerRateObservationSequence1OnlyExistsValidator();
	}
}
