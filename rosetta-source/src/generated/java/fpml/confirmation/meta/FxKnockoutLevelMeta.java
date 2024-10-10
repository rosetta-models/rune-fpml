package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxKnockoutLevel;
import fpml.confirmation.validation.FxKnockoutLevelTypeFormatValidator;
import fpml.confirmation.validation.FxKnockoutLevelValidator;
import fpml.confirmation.validation.exists.FxKnockoutLevelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxKnockoutLevel.class)
public class FxKnockoutLevelMeta implements RosettaMetaData<FxKnockoutLevel> {

	@Override
	public List<Validator<? super FxKnockoutLevel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxKnockoutLevel>create(fpml.confirmation.validation.datarule.FxKnockoutLevelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxKnockoutLevel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxKnockoutLevel> validator() {
		return new FxKnockoutLevelValidator();
	}

	@Override
	public Validator<? super FxKnockoutLevel> typeFormatValidator() {
		return new FxKnockoutLevelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxKnockoutLevel, Set<String>> onlyExistsValidator() {
		return new FxKnockoutLevelOnlyExistsValidator();
	}
}
