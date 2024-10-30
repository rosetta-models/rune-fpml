package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditEventsReference;
import fpml.confirmation.validation.CreditEventsReferenceTypeFormatValidator;
import fpml.confirmation.validation.CreditEventsReferenceValidator;
import fpml.confirmation.validation.exists.CreditEventsReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CreditEventsReference.class)
public class CreditEventsReferenceMeta implements RosettaMetaData<CreditEventsReference> {

	@Override
	public List<Validator<? super CreditEventsReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditEventsReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditEventsReference> validator() {
		return new CreditEventsReferenceValidator();
	}

	@Override
	public Validator<? super CreditEventsReference> typeFormatValidator() {
		return new CreditEventsReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditEventsReference, Set<String>> onlyExistsValidator() {
		return new CreditEventsReferenceOnlyExistsValidator();
	}
}
