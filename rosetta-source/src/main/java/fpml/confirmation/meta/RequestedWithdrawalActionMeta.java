package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RequestedWithdrawalAction;
import fpml.confirmation.validation.RequestedWithdrawalActionTypeFormatValidator;
import fpml.confirmation.validation.RequestedWithdrawalActionValidator;
import fpml.confirmation.validation.exists.RequestedWithdrawalActionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RequestedWithdrawalAction.class)
public class RequestedWithdrawalActionMeta implements RosettaMetaData<RequestedWithdrawalAction> {

	@Override
	public List<Validator<? super RequestedWithdrawalAction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestedWithdrawalAction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RequestedWithdrawalAction> validator() {
		return new RequestedWithdrawalActionValidator();
	}

	@Override
	public Validator<? super RequestedWithdrawalAction> typeFormatValidator() {
		return new RequestedWithdrawalActionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestedWithdrawalAction, Set<String>> onlyExistsValidator() {
		return new RequestedWithdrawalActionOnlyExistsValidator();
	}
}
