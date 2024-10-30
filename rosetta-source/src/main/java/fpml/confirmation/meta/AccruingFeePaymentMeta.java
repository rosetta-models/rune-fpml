package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccruingFeePayment;
import fpml.confirmation.validation.AccruingFeePaymentTypeFormatValidator;
import fpml.confirmation.validation.AccruingFeePaymentValidator;
import fpml.confirmation.validation.exists.AccruingFeePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AccruingFeePayment.class)
public class AccruingFeePaymentMeta implements RosettaMetaData<AccruingFeePayment> {

	@Override
	public List<Validator<? super AccruingFeePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccruingFeePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccruingFeePayment> validator() {
		return new AccruingFeePaymentValidator();
	}

	@Override
	public Validator<? super AccruingFeePayment> typeFormatValidator() {
		return new AccruingFeePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccruingFeePayment, Set<String>> onlyExistsValidator() {
		return new AccruingFeePaymentOnlyExistsValidator();
	}
}
