package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdditionalPaymentAmount;
import fpml.confirmation.validation.AdditionalPaymentAmountTypeFormatValidator;
import fpml.confirmation.validation.AdditionalPaymentAmountValidator;
import fpml.confirmation.validation.exists.AdditionalPaymentAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AdditionalPaymentAmount.class)
public class AdditionalPaymentAmountMeta implements RosettaMetaData<AdditionalPaymentAmount> {

	@Override
	public List<Validator<? super AdditionalPaymentAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdditionalPaymentAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AdditionalPaymentAmount> validator() {
		return new AdditionalPaymentAmountValidator();
	}

	@Override
	public Validator<? super AdditionalPaymentAmount> typeFormatValidator() {
		return new AdditionalPaymentAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalPaymentAmount, Set<String>> onlyExistsValidator() {
		return new AdditionalPaymentAmountOnlyExistsValidator();
	}
}
