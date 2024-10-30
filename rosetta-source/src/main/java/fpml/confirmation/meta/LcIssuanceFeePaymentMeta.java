package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LcIssuanceFeePayment;
import fpml.confirmation.validation.LcIssuanceFeePaymentTypeFormatValidator;
import fpml.confirmation.validation.LcIssuanceFeePaymentValidator;
import fpml.confirmation.validation.exists.LcIssuanceFeePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LcIssuanceFeePayment.class)
public class LcIssuanceFeePaymentMeta implements RosettaMetaData<LcIssuanceFeePayment> {

	@Override
	public List<Validator<? super LcIssuanceFeePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LcIssuanceFeePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LcIssuanceFeePayment> validator() {
		return new LcIssuanceFeePaymentValidator();
	}

	@Override
	public Validator<? super LcIssuanceFeePayment> typeFormatValidator() {
		return new LcIssuanceFeePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LcIssuanceFeePayment, Set<String>> onlyExistsValidator() {
		return new LcIssuanceFeePaymentOnlyExistsValidator();
	}
}
