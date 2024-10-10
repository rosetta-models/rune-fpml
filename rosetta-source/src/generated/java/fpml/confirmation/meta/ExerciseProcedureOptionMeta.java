package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExerciseProcedureOption;
import fpml.confirmation.validation.ExerciseProcedureOptionTypeFormatValidator;
import fpml.confirmation.validation.ExerciseProcedureOptionValidator;
import fpml.confirmation.validation.exists.ExerciseProcedureOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ExerciseProcedureOption.class)
public class ExerciseProcedureOptionMeta implements RosettaMetaData<ExerciseProcedureOption> {

	@Override
	public List<Validator<? super ExerciseProcedureOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ExerciseProcedureOption>create(fpml.confirmation.validation.datarule.ExerciseProcedureOptionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ExerciseProcedureOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExerciseProcedureOption> validator() {
		return new ExerciseProcedureOptionValidator();
	}

	@Override
	public Validator<? super ExerciseProcedureOption> typeFormatValidator() {
		return new ExerciseProcedureOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExerciseProcedureOption, Set<String>> onlyExistsValidator() {
		return new ExerciseProcedureOptionOnlyExistsValidator();
	}
}
