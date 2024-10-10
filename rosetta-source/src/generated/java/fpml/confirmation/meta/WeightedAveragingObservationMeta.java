package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.WeightedAveragingObservation;
import fpml.confirmation.validation.WeightedAveragingObservationTypeFormatValidator;
import fpml.confirmation.validation.WeightedAveragingObservationValidator;
import fpml.confirmation.validation.exists.WeightedAveragingObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=WeightedAveragingObservation.class)
public class WeightedAveragingObservationMeta implements RosettaMetaData<WeightedAveragingObservation> {

	@Override
	public List<Validator<? super WeightedAveragingObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.WeightedAveragingObservation>create(fpml.confirmation.validation.datarule.WeightedAveragingObservationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super WeightedAveragingObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super WeightedAveragingObservation> validator() {
		return new WeightedAveragingObservationValidator();
	}

	@Override
	public Validator<? super WeightedAveragingObservation> typeFormatValidator() {
		return new WeightedAveragingObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeightedAveragingObservation, Set<String>> onlyExistsValidator() {
		return new WeightedAveragingObservationOnlyExistsValidator();
	}
}
