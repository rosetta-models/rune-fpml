package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculationPeriodDatesReference;
import fpml.confirmation.validation.CalculationPeriodDatesReferenceTypeFormatValidator;
import fpml.confirmation.validation.CalculationPeriodDatesReferenceValidator;
import fpml.confirmation.validation.exists.CalculationPeriodDatesReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CalculationPeriodDatesReference.class)
public class CalculationPeriodDatesReferenceMeta implements RosettaMetaData<CalculationPeriodDatesReference> {

	@Override
	public List<Validator<? super CalculationPeriodDatesReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculationPeriodDatesReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CalculationPeriodDatesReference> validator() {
		return new CalculationPeriodDatesReferenceValidator();
	}

	@Override
	public Validator<? super CalculationPeriodDatesReference> typeFormatValidator() {
		return new CalculationPeriodDatesReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationPeriodDatesReference, Set<String>> onlyExistsValidator() {
		return new CalculationPeriodDatesReferenceOnlyExistsValidator();
	}
}
