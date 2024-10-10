package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NonRecurringFeePayment;
import fpml.confirmation.validation.NonRecurringFeePaymentTypeFormatValidator;
import fpml.confirmation.validation.NonRecurringFeePaymentValidator;
import fpml.confirmation.validation.exists.NonRecurringFeePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NonRecurringFeePayment.class)
public class NonRecurringFeePaymentMeta implements RosettaMetaData<NonRecurringFeePayment> {

	@Override
	public List<Validator<? super NonRecurringFeePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NonRecurringFeePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NonRecurringFeePayment> validator() {
		return new NonRecurringFeePaymentValidator();
	}

	@Override
	public Validator<? super NonRecurringFeePayment> typeFormatValidator() {
		return new NonRecurringFeePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NonRecurringFeePayment, Set<String>> onlyExistsValidator() {
		return new NonRecurringFeePaymentOnlyExistsValidator();
	}
}
