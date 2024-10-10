package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAverageRateObservation;
import fpml.confirmation.validation.FxAverageRateObservationTypeFormatValidator;
import fpml.confirmation.validation.FxAverageRateObservationValidator;
import fpml.confirmation.validation.exists.FxAverageRateObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAverageRateObservation.class)
public class FxAverageRateObservationMeta implements RosettaMetaData<FxAverageRateObservation> {

	@Override
	public List<Validator<? super FxAverageRateObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAverageRateObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAverageRateObservation> validator() {
		return new FxAverageRateObservationValidator();
	}

	@Override
	public Validator<? super FxAverageRateObservation> typeFormatValidator() {
		return new FxAverageRateObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAverageRateObservation, Set<String>> onlyExistsValidator() {
		return new FxAverageRateObservationOnlyExistsValidator();
	}
}
