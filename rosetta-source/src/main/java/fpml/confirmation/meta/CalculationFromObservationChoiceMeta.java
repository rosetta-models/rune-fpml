package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculationFromObservationChoice;
import fpml.confirmation.validation.CalculationFromObservationChoiceTypeFormatValidator;
import fpml.confirmation.validation.CalculationFromObservationChoiceValidator;
import fpml.confirmation.validation.exists.CalculationFromObservationChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CalculationFromObservationChoice.class)
public class CalculationFromObservationChoiceMeta implements RosettaMetaData<CalculationFromObservationChoice> {

	@Override
	public List<Validator<? super CalculationFromObservationChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CalculationFromObservationChoice>create(fpml.confirmation.validation.datarule.CalculationFromObservationChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CalculationFromObservationChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CalculationFromObservationChoice> validator() {
		return new CalculationFromObservationChoiceValidator();
	}

	@Override
	public Validator<? super CalculationFromObservationChoice> typeFormatValidator() {
		return new CalculationFromObservationChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationFromObservationChoice, Set<String>> onlyExistsValidator() {
		return new CalculationFromObservationChoiceOnlyExistsValidator();
	}
}
