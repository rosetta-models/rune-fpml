package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PrePayment;
import fpml.confirmation.validation.PrePaymentTypeFormatValidator;
import fpml.confirmation.validation.PrePaymentValidator;
import fpml.confirmation.validation.exists.PrePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PrePayment.class)
public class PrePaymentMeta implements RosettaMetaData<PrePayment> {

	@Override
	public List<Validator<? super PrePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PrePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PrePayment> validator() {
		return new PrePaymentValidator();
	}

	@Override
	public Validator<? super PrePayment> typeFormatValidator() {
		return new PrePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PrePayment, Set<String>> onlyExistsValidator() {
		return new PrePaymentOnlyExistsValidator();
	}
}
