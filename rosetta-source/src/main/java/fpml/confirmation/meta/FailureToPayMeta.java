package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FailureToPay;
import fpml.confirmation.validation.FailureToPayTypeFormatValidator;
import fpml.confirmation.validation.FailureToPayValidator;
import fpml.confirmation.validation.exists.FailureToPayOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FailureToPay.class)
public class FailureToPayMeta implements RosettaMetaData<FailureToPay> {

	@Override
	public List<Validator<? super FailureToPay>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FailureToPay, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FailureToPay> validator() {
		return new FailureToPayValidator();
	}

	@Override
	public Validator<? super FailureToPay> typeFormatValidator() {
		return new FailureToPayTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FailureToPay, Set<String>> onlyExistsValidator() {
		return new FailureToPayOnlyExistsValidator();
	}
}
