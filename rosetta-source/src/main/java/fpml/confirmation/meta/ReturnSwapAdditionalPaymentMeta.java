package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReturnSwapAdditionalPayment;
import fpml.confirmation.validation.ReturnSwapAdditionalPaymentTypeFormatValidator;
import fpml.confirmation.validation.ReturnSwapAdditionalPaymentValidator;
import fpml.confirmation.validation.exists.ReturnSwapAdditionalPaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ReturnSwapAdditionalPayment.class)
public class ReturnSwapAdditionalPaymentMeta implements RosettaMetaData<ReturnSwapAdditionalPayment> {

	@Override
	public List<Validator<? super ReturnSwapAdditionalPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReturnSwapAdditionalPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReturnSwapAdditionalPayment> validator() {
		return new ReturnSwapAdditionalPaymentValidator();
	}

	@Override
	public Validator<? super ReturnSwapAdditionalPayment> typeFormatValidator() {
		return new ReturnSwapAdditionalPaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnSwapAdditionalPayment, Set<String>> onlyExistsValidator() {
		return new ReturnSwapAdditionalPaymentOnlyExistsValidator();
	}
}
