package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculationFromObservation;
import fpml.confirmation.validation.CalculationFromObservationTypeFormatValidator;
import fpml.confirmation.validation.CalculationFromObservationValidator;
import fpml.confirmation.validation.exists.CalculationFromObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CalculationFromObservation.class)
public class CalculationFromObservationMeta implements RosettaMetaData<CalculationFromObservation> {

	@Override
	public List<Validator<? super CalculationFromObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CalculationFromObservation>create(fpml.confirmation.validation.datarule.CalculationFromObservationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CalculationFromObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CalculationFromObservation> validator() {
		return new CalculationFromObservationValidator();
	}

	@Override
	public Validator<? super CalculationFromObservation> typeFormatValidator() {
		return new CalculationFromObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationFromObservation, Set<String>> onlyExistsValidator() {
		return new CalculationFromObservationOnlyExistsValidator();
	}
}
