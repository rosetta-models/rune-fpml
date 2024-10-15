package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxCoreDetailsModel;
import fpml.confirmation.validation.FxCoreDetailsModelTypeFormatValidator;
import fpml.confirmation.validation.FxCoreDetailsModelValidator;
import fpml.confirmation.validation.exists.FxCoreDetailsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxCoreDetailsModel.class)
public class FxCoreDetailsModelMeta implements RosettaMetaData<FxCoreDetailsModel> {

	@Override
	public List<Validator<? super FxCoreDetailsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxCoreDetailsModel>create(fpml.confirmation.validation.datarule.FxCoreDetailsModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxCoreDetailsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxCoreDetailsModel> validator() {
		return new FxCoreDetailsModelValidator();
	}

	@Override
	public Validator<? super FxCoreDetailsModel> typeFormatValidator() {
		return new FxCoreDetailsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxCoreDetailsModel, Set<String>> onlyExistsValidator() {
		return new FxCoreDetailsModelOnlyExistsValidator();
	}
}
