package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TriggerRateObservation;
import fpml.confirmation.validation.TriggerRateObservationTypeFormatValidator;
import fpml.confirmation.validation.TriggerRateObservationValidator;
import fpml.confirmation.validation.exists.TriggerRateObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TriggerRateObservation.class)
public class TriggerRateObservationMeta implements RosettaMetaData<TriggerRateObservation> {

	@Override
	public List<Validator<? super TriggerRateObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TriggerRateObservation>create(fpml.confirmation.validation.datarule.TriggerRateObservationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TriggerRateObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TriggerRateObservation> validator() {
		return new TriggerRateObservationValidator();
	}

	@Override
	public Validator<? super TriggerRateObservation> typeFormatValidator() {
		return new TriggerRateObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TriggerRateObservation, Set<String>> onlyExistsValidator() {
		return new TriggerRateObservationOnlyExistsValidator();
	}
}
