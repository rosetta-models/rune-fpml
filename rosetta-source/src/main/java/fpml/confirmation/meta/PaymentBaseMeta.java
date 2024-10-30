package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PaymentBase;
import fpml.confirmation.validation.PaymentBaseTypeFormatValidator;
import fpml.confirmation.validation.PaymentBaseValidator;
import fpml.confirmation.validation.exists.PaymentBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PaymentBase.class)
public class PaymentBaseMeta implements RosettaMetaData<PaymentBase> {

	@Override
	public List<Validator<? super PaymentBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaymentBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PaymentBase> validator() {
		return new PaymentBaseValidator();
	}

	@Override
	public Validator<? super PaymentBase> typeFormatValidator() {
		return new PaymentBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentBase, Set<String>> onlyExistsValidator() {
		return new PaymentBaseOnlyExistsValidator();
	}
}
