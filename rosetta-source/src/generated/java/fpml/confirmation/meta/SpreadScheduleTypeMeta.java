package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SpreadScheduleType;
import fpml.confirmation.validation.SpreadScheduleTypeTypeFormatValidator;
import fpml.confirmation.validation.SpreadScheduleTypeValidator;
import fpml.confirmation.validation.exists.SpreadScheduleTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SpreadScheduleType.class)
public class SpreadScheduleTypeMeta implements RosettaMetaData<SpreadScheduleType> {

	@Override
	public List<Validator<? super SpreadScheduleType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SpreadScheduleType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SpreadScheduleType> validator() {
		return new SpreadScheduleTypeValidator();
	}

	@Override
	public Validator<? super SpreadScheduleType> typeFormatValidator() {
		return new SpreadScheduleTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SpreadScheduleType, Set<String>> onlyExistsValidator() {
		return new SpreadScheduleTypeOnlyExistsValidator();
	}
}
