package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PeriodOptionalEndModel;
import fpml.confirmation.validation.PeriodOptionalEndModelTypeFormatValidator;
import fpml.confirmation.validation.PeriodOptionalEndModelValidator;
import fpml.confirmation.validation.exists.PeriodOptionalEndModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PeriodOptionalEndModel.class)
public class PeriodOptionalEndModelMeta implements RosettaMetaData<PeriodOptionalEndModel> {

	@Override
	public List<Validator<? super PeriodOptionalEndModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PeriodOptionalEndModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PeriodOptionalEndModel> validator() {
		return new PeriodOptionalEndModelValidator();
	}

	@Override
	public Validator<? super PeriodOptionalEndModel> typeFormatValidator() {
		return new PeriodOptionalEndModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PeriodOptionalEndModel, Set<String>> onlyExistsValidator() {
		return new PeriodOptionalEndModelOnlyExistsValidator();
	}
}
