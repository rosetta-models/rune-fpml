package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetRebate;
import fpml.confirmation.validation.FxTargetRebateTypeFormatValidator;
import fpml.confirmation.validation.FxTargetRebateValidator;
import fpml.confirmation.validation.exists.FxTargetRebateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxTargetRebate.class)
public class FxTargetRebateMeta implements RosettaMetaData<FxTargetRebate> {

	@Override
	public List<Validator<? super FxTargetRebate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxTargetRebate>create(fpml.confirmation.validation.datarule.FxTargetRebateChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxTargetRebate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetRebate> validator() {
		return new FxTargetRebateValidator();
	}

	@Override
	public Validator<? super FxTargetRebate> typeFormatValidator() {
		return new FxTargetRebateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetRebate, Set<String>> onlyExistsValidator() {
		return new FxTargetRebateOnlyExistsValidator();
	}
}
