package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.UpfrontFeePayment;
import fpml.confirmation.validation.UpfrontFeePaymentTypeFormatValidator;
import fpml.confirmation.validation.UpfrontFeePaymentValidator;
import fpml.confirmation.validation.exists.UpfrontFeePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=UpfrontFeePayment.class)
public class UpfrontFeePaymentMeta implements RosettaMetaData<UpfrontFeePayment> {

	@Override
	public List<Validator<? super UpfrontFeePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UpfrontFeePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super UpfrontFeePayment> validator() {
		return new UpfrontFeePaymentValidator();
	}

	@Override
	public Validator<? super UpfrontFeePayment> typeFormatValidator() {
		return new UpfrontFeePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UpfrontFeePayment, Set<String>> onlyExistsValidator() {
		return new UpfrontFeePaymentOnlyExistsValidator();
	}
}
