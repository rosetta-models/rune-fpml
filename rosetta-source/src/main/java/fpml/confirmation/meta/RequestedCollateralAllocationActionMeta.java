package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RequestedCollateralAllocationAction;
import fpml.confirmation.validation.RequestedCollateralAllocationActionTypeFormatValidator;
import fpml.confirmation.validation.RequestedCollateralAllocationActionValidator;
import fpml.confirmation.validation.exists.RequestedCollateralAllocationActionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RequestedCollateralAllocationAction.class)
public class RequestedCollateralAllocationActionMeta implements RosettaMetaData<RequestedCollateralAllocationAction> {

	@Override
	public List<Validator<? super RequestedCollateralAllocationAction>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestedCollateralAllocationAction, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RequestedCollateralAllocationAction> validator() {
		return new RequestedCollateralAllocationActionValidator();
	}

	@Override
	public Validator<? super RequestedCollateralAllocationAction> typeFormatValidator() {
		return new RequestedCollateralAllocationActionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestedCollateralAllocationAction, Set<String>> onlyExistsValidator() {
		return new RequestedCollateralAllocationActionOnlyExistsValidator();
	}
}
