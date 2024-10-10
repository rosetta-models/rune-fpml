package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualForward;
import fpml.confirmation.validation.FxAccrualForwardTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualForwardValidator;
import fpml.confirmation.validation.exists.FxAccrualForwardOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAccrualForward.class)
public class FxAccrualForwardMeta implements RosettaMetaData<FxAccrualForward> {

	@Override
	public List<Validator<? super FxAccrualForward>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualForward, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualForward> validator() {
		return new FxAccrualForwardValidator();
	}

	@Override
	public Validator<? super FxAccrualForward> typeFormatValidator() {
		return new FxAccrualForwardTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualForward, Set<String>> onlyExistsValidator() {
		return new FxAccrualForwardOnlyExistsValidator();
	}
}
