package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MiscFeePayment;
import fpml.confirmation.validation.MiscFeePaymentTypeFormatValidator;
import fpml.confirmation.validation.MiscFeePaymentValidator;
import fpml.confirmation.validation.exists.MiscFeePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MiscFeePayment.class)
public class MiscFeePaymentMeta implements RosettaMetaData<MiscFeePayment> {

	@Override
	public List<Validator<? super MiscFeePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MiscFeePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MiscFeePayment> validator() {
		return new MiscFeePaymentValidator();
	}

	@Override
	public Validator<? super MiscFeePayment> typeFormatValidator() {
		return new MiscFeePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MiscFeePayment, Set<String>> onlyExistsValidator() {
		return new MiscFeePaymentOnlyExistsValidator();
	}
}
