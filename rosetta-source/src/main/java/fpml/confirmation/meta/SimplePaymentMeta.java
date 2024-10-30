package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SimplePayment;
import fpml.confirmation.validation.SimplePaymentTypeFormatValidator;
import fpml.confirmation.validation.SimplePaymentValidator;
import fpml.confirmation.validation.exists.SimplePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SimplePayment.class)
public class SimplePaymentMeta implements RosettaMetaData<SimplePayment> {

	@Override
	public List<Validator<? super SimplePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SimplePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SimplePayment> validator() {
		return new SimplePaymentValidator();
	}

	@Override
	public Validator<? super SimplePayment> typeFormatValidator() {
		return new SimplePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SimplePayment, Set<String>> onlyExistsValidator() {
		return new SimplePaymentOnlyExistsValidator();
	}
}
