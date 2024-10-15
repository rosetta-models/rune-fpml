package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PaymentDatesReference;
import fpml.confirmation.validation.PaymentDatesReferenceTypeFormatValidator;
import fpml.confirmation.validation.PaymentDatesReferenceValidator;
import fpml.confirmation.validation.exists.PaymentDatesReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PaymentDatesReference.class)
public class PaymentDatesReferenceMeta implements RosettaMetaData<PaymentDatesReference> {

	@Override
	public List<Validator<? super PaymentDatesReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaymentDatesReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PaymentDatesReference> validator() {
		return new PaymentDatesReferenceValidator();
	}

	@Override
	public Validator<? super PaymentDatesReference> typeFormatValidator() {
		return new PaymentDatesReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentDatesReference, Set<String>> onlyExistsValidator() {
		return new PaymentDatesReferenceOnlyExistsValidator();
	}
}
