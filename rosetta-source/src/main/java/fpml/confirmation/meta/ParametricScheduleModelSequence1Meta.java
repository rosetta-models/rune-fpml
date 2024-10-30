package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ParametricScheduleModelSequence1;
import fpml.confirmation.validation.ParametricScheduleModelSequence1TypeFormatValidator;
import fpml.confirmation.validation.ParametricScheduleModelSequence1Validator;
import fpml.confirmation.validation.exists.ParametricScheduleModelSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ParametricScheduleModelSequence1.class)
public class ParametricScheduleModelSequence1Meta implements RosettaMetaData<ParametricScheduleModelSequence1> {

	@Override
	public List<Validator<? super ParametricScheduleModelSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ParametricScheduleModelSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ParametricScheduleModelSequence1> validator() {
		return new ParametricScheduleModelSequence1Validator();
	}

	@Override
	public Validator<? super ParametricScheduleModelSequence1> typeFormatValidator() {
		return new ParametricScheduleModelSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ParametricScheduleModelSequence1, Set<String>> onlyExistsValidator() {
		return new ParametricScheduleModelSequence1OnlyExistsValidator();
	}
}
