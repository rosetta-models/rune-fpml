package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TouchRateObservation;
import fpml.confirmation.validation.TouchRateObservationTypeFormatValidator;
import fpml.confirmation.validation.TouchRateObservationValidator;
import fpml.confirmation.validation.exists.TouchRateObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TouchRateObservation.class)
public class TouchRateObservationMeta implements RosettaMetaData<TouchRateObservation> {

	@Override
	public List<Validator<? super TouchRateObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TriggerRateObservation>create(fpml.confirmation.validation.datarule.TriggerRateObservationChoice.class),
			factory.<fpml.confirmation.TouchRateObservation>create(fpml.confirmation.validation.datarule.TouchRateObservationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TouchRateObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TouchRateObservation> validator() {
		return new TouchRateObservationValidator();
	}

	@Override
	public Validator<? super TouchRateObservation> typeFormatValidator() {
		return new TouchRateObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TouchRateObservation, Set<String>> onlyExistsValidator() {
		return new TouchRateObservationOnlyExistsValidator();
	}
}
