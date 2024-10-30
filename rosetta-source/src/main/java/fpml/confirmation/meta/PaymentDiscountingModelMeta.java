package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PaymentDiscountingModel;
import fpml.confirmation.validation.PaymentDiscountingModelTypeFormatValidator;
import fpml.confirmation.validation.PaymentDiscountingModelValidator;
import fpml.confirmation.validation.exists.PaymentDiscountingModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PaymentDiscountingModel.class)
public class PaymentDiscountingModelMeta implements RosettaMetaData<PaymentDiscountingModel> {

	@Override
	public List<Validator<? super PaymentDiscountingModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaymentDiscountingModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PaymentDiscountingModel> validator() {
		return new PaymentDiscountingModelValidator();
	}

	@Override
	public Validator<? super PaymentDiscountingModel> typeFormatValidator() {
		return new PaymentDiscountingModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentDiscountingModel, Set<String>> onlyExistsValidator() {
		return new PaymentDiscountingModelOnlyExistsValidator();
	}
}
