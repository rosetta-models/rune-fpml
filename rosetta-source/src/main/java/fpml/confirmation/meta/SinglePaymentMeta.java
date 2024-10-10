package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SinglePayment;
import fpml.confirmation.validation.SinglePaymentTypeFormatValidator;
import fpml.confirmation.validation.SinglePaymentValidator;
import fpml.confirmation.validation.exists.SinglePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SinglePayment.class)
public class SinglePaymentMeta implements RosettaMetaData<SinglePayment> {

	@Override
	public List<Validator<? super SinglePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SinglePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SinglePayment> validator() {
		return new SinglePaymentValidator();
	}

	@Override
	public Validator<? super SinglePayment> typeFormatValidator() {
		return new SinglePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SinglePayment, Set<String>> onlyExistsValidator() {
		return new SinglePaymentOnlyExistsValidator();
	}
}
