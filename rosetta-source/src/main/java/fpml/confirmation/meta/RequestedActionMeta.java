package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RequestedAction;
import fpml.confirmation.validation.RequestedActionTypeFormatValidator;
import fpml.confirmation.validation.RequestedActionValidator;
import fpml.confirmation.validation.exists.RequestedActionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RequestedAction.class)
public class RequestedActionMeta implements RosettaMetaData<RequestedAction> {

	@Override
	public List<Validator<? super RequestedAction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestedAction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RequestedAction> validator() {
		return new RequestedActionValidator();
	}

	@Override
	public Validator<? super RequestedAction> typeFormatValidator() {
		return new RequestedActionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestedAction, Set<String>> onlyExistsValidator() {
		return new RequestedActionOnlyExistsValidator();
	}
}
