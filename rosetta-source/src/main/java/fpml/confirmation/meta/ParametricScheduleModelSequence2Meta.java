package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ParametricScheduleModelSequence2;
import fpml.confirmation.validation.ParametricScheduleModelSequence2TypeFormatValidator;
import fpml.confirmation.validation.ParametricScheduleModelSequence2Validator;
import fpml.confirmation.validation.exists.ParametricScheduleModelSequence2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ParametricScheduleModelSequence2.class)
public class ParametricScheduleModelSequence2Meta implements RosettaMetaData<ParametricScheduleModelSequence2> {

	@Override
	public List<Validator<? super ParametricScheduleModelSequence2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ParametricScheduleModelSequence2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ParametricScheduleModelSequence2> validator() {
		return new ParametricScheduleModelSequence2Validator();
	}

	@Override
	public Validator<? super ParametricScheduleModelSequence2> typeFormatValidator() {
		return new ParametricScheduleModelSequence2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ParametricScheduleModelSequence2, Set<String>> onlyExistsValidator() {
		return new ParametricScheduleModelSequence2OnlyExistsValidator();
	}
}
