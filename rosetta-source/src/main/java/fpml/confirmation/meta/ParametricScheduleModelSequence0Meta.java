package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ParametricScheduleModelSequence0;
import fpml.confirmation.validation.ParametricScheduleModelSequence0TypeFormatValidator;
import fpml.confirmation.validation.ParametricScheduleModelSequence0Validator;
import fpml.confirmation.validation.exists.ParametricScheduleModelSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ParametricScheduleModelSequence0.class)
public class ParametricScheduleModelSequence0Meta implements RosettaMetaData<ParametricScheduleModelSequence0> {

	@Override
	public List<Validator<? super ParametricScheduleModelSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ParametricScheduleModelSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ParametricScheduleModelSequence0> validator() {
		return new ParametricScheduleModelSequence0Validator();
	}

	@Override
	public Validator<? super ParametricScheduleModelSequence0> typeFormatValidator() {
		return new ParametricScheduleModelSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ParametricScheduleModelSequence0, Set<String>> onlyExistsValidator() {
		return new ParametricScheduleModelSequence0OnlyExistsValidator();
	}
}
