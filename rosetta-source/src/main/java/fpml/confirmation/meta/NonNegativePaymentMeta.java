package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NonNegativePayment;
import fpml.confirmation.validation.NonNegativePaymentTypeFormatValidator;
import fpml.confirmation.validation.NonNegativePaymentValidator;
import fpml.confirmation.validation.exists.NonNegativePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NonNegativePayment.class)
public class NonNegativePaymentMeta implements RosettaMetaData<NonNegativePayment> {

	@Override
	public List<Validator<? super NonNegativePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonNegativePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NonNegativePayment> validator() {
		return new NonNegativePaymentValidator();
	}

	@Override
	public Validator<? super NonNegativePayment> typeFormatValidator() {
		return new NonNegativePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonNegativePayment, Set<String>> onlyExistsValidator() {
		return new NonNegativePaymentOnlyExistsValidator();
	}
}
