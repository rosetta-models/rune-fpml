package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxFlexibleForward;
import fpml.confirmation.validation.FxFlexibleForwardTypeFormatValidator;
import fpml.confirmation.validation.FxFlexibleForwardValidator;
import fpml.confirmation.validation.exists.FxFlexibleForwardOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxFlexibleForward.class)
public class FxFlexibleForwardMeta implements RosettaMetaData<FxFlexibleForward> {

	@Override
	public List<Validator<? super FxFlexibleForward>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxFlexibleForward, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxFlexibleForward> validator() {
		return new FxFlexibleForwardValidator();
	}

	@Override
	public Validator<? super FxFlexibleForward> typeFormatValidator() {
		return new FxFlexibleForwardTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFlexibleForward, Set<String>> onlyExistsValidator() {
		return new FxFlexibleForwardOnlyExistsValidator();
	}
}
