package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PeriodModel;
import fpml.confirmation.validation.PeriodModelTypeFormatValidator;
import fpml.confirmation.validation.PeriodModelValidator;
import fpml.confirmation.validation.exists.PeriodModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PeriodModel.class)
public class PeriodModelMeta implements RosettaMetaData<PeriodModel> {

	@Override
	public List<Validator<? super PeriodModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PeriodModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PeriodModel> validator() {
		return new PeriodModelValidator();
	}

	@Override
	public Validator<? super PeriodModel> typeFormatValidator() {
		return new PeriodModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PeriodModel, Set<String>> onlyExistsValidator() {
		return new PeriodModelOnlyExistsValidator();
	}
}
