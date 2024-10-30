package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculationPeriodsDatesReference;
import fpml.confirmation.validation.CalculationPeriodsDatesReferenceTypeFormatValidator;
import fpml.confirmation.validation.CalculationPeriodsDatesReferenceValidator;
import fpml.confirmation.validation.exists.CalculationPeriodsDatesReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CalculationPeriodsDatesReference.class)
public class CalculationPeriodsDatesReferenceMeta implements RosettaMetaData<CalculationPeriodsDatesReference> {

	@Override
	public List<Validator<? super CalculationPeriodsDatesReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculationPeriodsDatesReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CalculationPeriodsDatesReference> validator() {
		return new CalculationPeriodsDatesReferenceValidator();
	}

	@Override
	public Validator<? super CalculationPeriodsDatesReference> typeFormatValidator() {
		return new CalculationPeriodsDatesReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationPeriodsDatesReference, Set<String>> onlyExistsValidator() {
		return new CalculationPeriodsDatesReferenceOnlyExistsValidator();
	}
}
