package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CalculationPeriodsReference;
import fpml.confirmation.validation.CalculationPeriodsReferenceTypeFormatValidator;
import fpml.confirmation.validation.CalculationPeriodsReferenceValidator;
import fpml.confirmation.validation.exists.CalculationPeriodsReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CalculationPeriodsReference.class)
public class CalculationPeriodsReferenceMeta implements RosettaMetaData<CalculationPeriodsReference> {

	@Override
	public List<Validator<? super CalculationPeriodsReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculationPeriodsReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CalculationPeriodsReference> validator() {
		return new CalculationPeriodsReferenceValidator();
	}

	@Override
	public Validator<? super CalculationPeriodsReference> typeFormatValidator() {
		return new CalculationPeriodsReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationPeriodsReference, Set<String>> onlyExistsValidator() {
		return new CalculationPeriodsReferenceOnlyExistsValidator();
	}
}
