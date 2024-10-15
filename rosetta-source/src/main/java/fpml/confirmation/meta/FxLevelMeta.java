package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxLevel;
import fpml.confirmation.validation.FxLevelTypeFormatValidator;
import fpml.confirmation.validation.FxLevelValidator;
import fpml.confirmation.validation.exists.FxLevelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxLevel.class)
public class FxLevelMeta implements RosettaMetaData<FxLevel> {

	@Override
	public List<Validator<? super FxLevel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxLevel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxLevel> validator() {
		return new FxLevelValidator();
	}

	@Override
	public Validator<? super FxLevel> typeFormatValidator() {
		return new FxLevelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxLevel, Set<String>> onlyExistsValidator() {
		return new FxLevelOnlyExistsValidator();
	}
}
