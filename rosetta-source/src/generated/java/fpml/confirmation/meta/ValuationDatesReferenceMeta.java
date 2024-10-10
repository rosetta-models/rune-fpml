package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ValuationDatesReference;
import fpml.confirmation.validation.ValuationDatesReferenceTypeFormatValidator;
import fpml.confirmation.validation.ValuationDatesReferenceValidator;
import fpml.confirmation.validation.exists.ValuationDatesReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ValuationDatesReference.class)
public class ValuationDatesReferenceMeta implements RosettaMetaData<ValuationDatesReference> {

	@Override
	public List<Validator<? super ValuationDatesReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ValuationDatesReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ValuationDatesReference> validator() {
		return new ValuationDatesReferenceValidator();
	}

	@Override
	public Validator<? super ValuationDatesReference> typeFormatValidator() {
		return new ValuationDatesReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationDatesReference, Set<String>> onlyExistsValidator() {
		return new ValuationDatesReferenceOnlyExistsValidator();
	}
}
