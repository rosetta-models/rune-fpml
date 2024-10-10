package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.WaiverFeePayment;
import fpml.confirmation.validation.WaiverFeePaymentTypeFormatValidator;
import fpml.confirmation.validation.WaiverFeePaymentValidator;
import fpml.confirmation.validation.exists.WaiverFeePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=WaiverFeePayment.class)
public class WaiverFeePaymentMeta implements RosettaMetaData<WaiverFeePayment> {

	@Override
	public List<Validator<? super WaiverFeePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WaiverFeePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super WaiverFeePayment> validator() {
		return new WaiverFeePaymentValidator();
	}

	@Override
	public Validator<? super WaiverFeePayment> typeFormatValidator() {
		return new WaiverFeePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WaiverFeePayment, Set<String>> onlyExistsValidator() {
		return new WaiverFeePaymentOnlyExistsValidator();
	}
}
