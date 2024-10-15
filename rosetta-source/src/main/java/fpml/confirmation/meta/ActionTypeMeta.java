package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ActionType;
import fpml.confirmation.validation.ActionTypeTypeFormatValidator;
import fpml.confirmation.validation.ActionTypeValidator;
import fpml.confirmation.validation.exists.ActionTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ActionType.class)
public class ActionTypeMeta implements RosettaMetaData<ActionType> {

	@Override
	public List<Validator<? super ActionType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ActionType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ActionType> validator() {
		return new ActionTypeValidator();
	}

	@Override
	public Validator<? super ActionType> typeFormatValidator() {
		return new ActionTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ActionType, Set<String>> onlyExistsValidator() {
		return new ActionTypeOnlyExistsValidator();
	}
}
