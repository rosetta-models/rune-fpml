package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FundingFeePayment;
import fpml.confirmation.validation.FundingFeePaymentTypeFormatValidator;
import fpml.confirmation.validation.FundingFeePaymentValidator;
import fpml.confirmation.validation.exists.FundingFeePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FundingFeePayment.class)
public class FundingFeePaymentMeta implements RosettaMetaData<FundingFeePayment> {

	@Override
	public List<Validator<? super FundingFeePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FundingFeePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FundingFeePayment> validator() {
		return new FundingFeePaymentValidator();
	}

	@Override
	public Validator<? super FundingFeePayment> typeFormatValidator() {
		return new FundingFeePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FundingFeePayment, Set<String>> onlyExistsValidator() {
		return new FundingFeePaymentOnlyExistsValidator();
	}
}
