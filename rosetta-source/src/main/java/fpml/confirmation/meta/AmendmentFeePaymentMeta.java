package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AmendmentFeePayment;
import fpml.confirmation.validation.AmendmentFeePaymentTypeFormatValidator;
import fpml.confirmation.validation.AmendmentFeePaymentValidator;
import fpml.confirmation.validation.exists.AmendmentFeePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AmendmentFeePayment.class)
public class AmendmentFeePaymentMeta implements RosettaMetaData<AmendmentFeePayment> {

	@Override
	public List<Validator<? super AmendmentFeePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AmendmentFeePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AmendmentFeePayment> validator() {
		return new AmendmentFeePaymentValidator();
	}

	@Override
	public Validator<? super AmendmentFeePayment> typeFormatValidator() {
		return new AmendmentFeePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AmendmentFeePayment, Set<String>> onlyExistsValidator() {
		return new AmendmentFeePaymentOnlyExistsValidator();
	}
}
