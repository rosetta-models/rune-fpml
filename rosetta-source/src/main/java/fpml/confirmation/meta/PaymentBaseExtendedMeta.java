package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PaymentBaseExtended;
import fpml.confirmation.validation.PaymentBaseExtendedTypeFormatValidator;
import fpml.confirmation.validation.PaymentBaseExtendedValidator;
import fpml.confirmation.validation.exists.PaymentBaseExtendedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PaymentBaseExtended.class)
public class PaymentBaseExtendedMeta implements RosettaMetaData<PaymentBaseExtended> {

	@Override
	public List<Validator<? super PaymentBaseExtended>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaymentBaseExtended, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PaymentBaseExtended> validator() {
		return new PaymentBaseExtendedValidator();
	}

	@Override
	public Validator<? super PaymentBaseExtended> typeFormatValidator() {
		return new PaymentBaseExtendedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentBaseExtended, Set<String>> onlyExistsValidator() {
		return new PaymentBaseExtendedOnlyExistsValidator();
	}
}
