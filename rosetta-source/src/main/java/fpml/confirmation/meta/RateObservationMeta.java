package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RateObservation;
import fpml.confirmation.validation.RateObservationTypeFormatValidator;
import fpml.confirmation.validation.RateObservationValidator;
import fpml.confirmation.validation.exists.RateObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RateObservation.class)
public class RateObservationMeta implements RosettaMetaData<RateObservation> {

	@Override
	public List<Validator<? super RateObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RateObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RateObservation> validator() {
		return new RateObservationValidator();
	}

	@Override
	public Validator<? super RateObservation> typeFormatValidator() {
		return new RateObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RateObservation, Set<String>> onlyExistsValidator() {
		return new RateObservationOnlyExistsValidator();
	}
}
