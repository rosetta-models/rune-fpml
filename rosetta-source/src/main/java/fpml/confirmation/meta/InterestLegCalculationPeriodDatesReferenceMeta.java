package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InterestLegCalculationPeriodDatesReference;
import fpml.confirmation.validation.InterestLegCalculationPeriodDatesReferenceTypeFormatValidator;
import fpml.confirmation.validation.InterestLegCalculationPeriodDatesReferenceValidator;
import fpml.confirmation.validation.exists.InterestLegCalculationPeriodDatesReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=InterestLegCalculationPeriodDatesReference.class)
public class InterestLegCalculationPeriodDatesReferenceMeta implements RosettaMetaData<InterestLegCalculationPeriodDatesReference> {

	@Override
	public List<Validator<? super InterestLegCalculationPeriodDatesReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestLegCalculationPeriodDatesReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InterestLegCalculationPeriodDatesReference> validator() {
		return new InterestLegCalculationPeriodDatesReferenceValidator();
	}

	@Override
	public Validator<? super InterestLegCalculationPeriodDatesReference> typeFormatValidator() {
		return new InterestLegCalculationPeriodDatesReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestLegCalculationPeriodDatesReference, Set<String>> onlyExistsValidator() {
		return new InterestLegCalculationPeriodDatesReferenceOnlyExistsValidator();
	}
}
