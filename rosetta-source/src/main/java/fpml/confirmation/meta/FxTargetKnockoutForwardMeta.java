package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetKnockoutForward;
import fpml.confirmation.validation.FxTargetKnockoutForwardTypeFormatValidator;
import fpml.confirmation.validation.FxTargetKnockoutForwardValidator;
import fpml.confirmation.validation.exists.FxTargetKnockoutForwardOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxTargetKnockoutForward.class)
public class FxTargetKnockoutForwardMeta implements RosettaMetaData<FxTargetKnockoutForward> {

	@Override
	public List<Validator<? super FxTargetKnockoutForward>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetKnockoutForward, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetKnockoutForward> validator() {
		return new FxTargetKnockoutForwardValidator();
	}

	@Override
	public Validator<? super FxTargetKnockoutForward> typeFormatValidator() {
		return new FxTargetKnockoutForwardTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetKnockoutForward, Set<String>> onlyExistsValidator() {
		return new FxTargetKnockoutForwardOnlyExistsValidator();
	}
}
