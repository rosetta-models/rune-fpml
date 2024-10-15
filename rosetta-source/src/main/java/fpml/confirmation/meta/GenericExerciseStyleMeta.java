package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GenericExerciseStyle;
import fpml.confirmation.validation.GenericExerciseStyleTypeFormatValidator;
import fpml.confirmation.validation.GenericExerciseStyleValidator;
import fpml.confirmation.validation.exists.GenericExerciseStyleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GenericExerciseStyle.class)
public class GenericExerciseStyleMeta implements RosettaMetaData<GenericExerciseStyle> {

	@Override
	public List<Validator<? super GenericExerciseStyle>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericExerciseStyle, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GenericExerciseStyle> validator() {
		return new GenericExerciseStyleValidator();
	}

	@Override
	public Validator<? super GenericExerciseStyle> typeFormatValidator() {
		return new GenericExerciseStyleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericExerciseStyle, Set<String>> onlyExistsValidator() {
		return new GenericExerciseStyleOnlyExistsValidator();
	}
}
