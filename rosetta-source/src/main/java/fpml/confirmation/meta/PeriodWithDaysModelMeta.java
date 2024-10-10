package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PeriodWithDaysModel;
import fpml.confirmation.validation.PeriodWithDaysModelTypeFormatValidator;
import fpml.confirmation.validation.PeriodWithDaysModelValidator;
import fpml.confirmation.validation.exists.PeriodWithDaysModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PeriodWithDaysModel.class)
public class PeriodWithDaysModelMeta implements RosettaMetaData<PeriodWithDaysModel> {

	@Override
	public List<Validator<? super PeriodWithDaysModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PeriodWithDaysModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PeriodWithDaysModel> validator() {
		return new PeriodWithDaysModelValidator();
	}

	@Override
	public Validator<? super PeriodWithDaysModel> typeFormatValidator() {
		return new PeriodWithDaysModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PeriodWithDaysModel, Set<String>> onlyExistsValidator() {
		return new PeriodWithDaysModelOnlyExistsValidator();
	}
}
