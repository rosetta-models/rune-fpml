package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTarget;
import fpml.confirmation.validation.FxTargetTypeFormatValidator;
import fpml.confirmation.validation.FxTargetValidator;
import fpml.confirmation.validation.exists.FxTargetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxTarget.class)
public class FxTargetMeta implements RosettaMetaData<FxTarget> {

	@Override
	public List<Validator<? super FxTarget>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxTarget>create(fpml.confirmation.validation.datarule.FxTargetChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxTarget, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTarget> validator() {
		return new FxTargetValidator();
	}

	@Override
	public Validator<? super FxTarget> typeFormatValidator() {
		return new FxTargetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTarget, Set<String>> onlyExistsValidator() {
		return new FxTargetOnlyExistsValidator();
	}
}
