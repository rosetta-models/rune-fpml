package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ClearingResultsModel;
import fpml.confirmation.validation.ClearingResultsModelTypeFormatValidator;
import fpml.confirmation.validation.ClearingResultsModelValidator;
import fpml.confirmation.validation.exists.ClearingResultsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ClearingResultsModel.class)
public class ClearingResultsModelMeta implements RosettaMetaData<ClearingResultsModel> {

	@Override
	public List<Validator<? super ClearingResultsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ClearingResultsModel>create(fpml.confirmation.validation.datarule.ClearingResultsModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ClearingResultsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ClearingResultsModel> validator() {
		return new ClearingResultsModelValidator();
	}

	@Override
	public Validator<? super ClearingResultsModel> typeFormatValidator() {
		return new ClearingResultsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingResultsModel, Set<String>> onlyExistsValidator() {
		return new ClearingResultsModelOnlyExistsValidator();
	}
}
