package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PaymentDetails;
import fpml.confirmation.validation.PaymentDetailsTypeFormatValidator;
import fpml.confirmation.validation.PaymentDetailsValidator;
import fpml.confirmation.validation.exists.PaymentDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PaymentDetails.class)
public class PaymentDetailsMeta implements RosettaMetaData<PaymentDetails> {

	@Override
	public List<Validator<? super PaymentDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaymentDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PaymentDetails> validator() {
		return new PaymentDetailsValidator();
	}

	@Override
	public Validator<? super PaymentDetails> typeFormatValidator() {
		return new PaymentDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentDetails, Set<String>> onlyExistsValidator() {
		return new PaymentDetailsOnlyExistsValidator();
	}
}
