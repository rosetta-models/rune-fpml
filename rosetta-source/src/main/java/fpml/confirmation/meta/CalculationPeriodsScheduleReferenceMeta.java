package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculationPeriodsScheduleReference;
import fpml.confirmation.validation.CalculationPeriodsScheduleReferenceTypeFormatValidator;
import fpml.confirmation.validation.CalculationPeriodsScheduleReferenceValidator;
import fpml.confirmation.validation.exists.CalculationPeriodsScheduleReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CalculationPeriodsScheduleReference.class)
public class CalculationPeriodsScheduleReferenceMeta implements RosettaMetaData<CalculationPeriodsScheduleReference> {

	@Override
	public List<Validator<? super CalculationPeriodsScheduleReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculationPeriodsScheduleReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CalculationPeriodsScheduleReference> validator() {
		return new CalculationPeriodsScheduleReferenceValidator();
	}

	@Override
	public Validator<? super CalculationPeriodsScheduleReference> typeFormatValidator() {
		return new CalculationPeriodsScheduleReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationPeriodsScheduleReference, Set<String>> onlyExistsValidator() {
		return new CalculationPeriodsScheduleReferenceOnlyExistsValidator();
	}
}
