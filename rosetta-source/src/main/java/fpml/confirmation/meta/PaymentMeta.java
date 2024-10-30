package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Payment;
import fpml.confirmation.validation.PaymentTypeFormatValidator;
import fpml.confirmation.validation.PaymentValidator;
import fpml.confirmation.validation.exists.PaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Payment.class)
public class PaymentMeta implements RosettaMetaData<Payment> {

	@Override
	public List<Validator<? super Payment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Payment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Payment> validator() {
		return new PaymentValidator();
	}

	@Override
	public Validator<? super Payment> typeFormatValidator() {
		return new PaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Payment, Set<String>> onlyExistsValidator() {
		return new PaymentOnlyExistsValidator();
	}
}
