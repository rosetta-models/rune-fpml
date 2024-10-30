package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ParametricScheduleModel;
import fpml.confirmation.validation.ParametricScheduleModelTypeFormatValidator;
import fpml.confirmation.validation.ParametricScheduleModelValidator;
import fpml.confirmation.validation.exists.ParametricScheduleModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ParametricScheduleModel.class)
public class ParametricScheduleModelMeta implements RosettaMetaData<ParametricScheduleModel> {

	@Override
	public List<Validator<? super ParametricScheduleModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ParametricScheduleModel>create(fpml.confirmation.validation.datarule.ParametricScheduleModelChoice0.class),
			factory.<fpml.confirmation.ParametricScheduleModel>create(fpml.confirmation.validation.datarule.ParametricScheduleModelChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super ParametricScheduleModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ParametricScheduleModel> validator() {
		return new ParametricScheduleModelValidator();
	}

	@Override
	public Validator<? super ParametricScheduleModel> typeFormatValidator() {
		return new ParametricScheduleModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ParametricScheduleModel, Set<String>> onlyExistsValidator() {
		return new ParametricScheduleModelOnlyExistsValidator();
	}
}
