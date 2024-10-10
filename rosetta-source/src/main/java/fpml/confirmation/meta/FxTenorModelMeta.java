package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTenorModel;
import fpml.confirmation.validation.FxTenorModelTypeFormatValidator;
import fpml.confirmation.validation.FxTenorModelValidator;
import fpml.confirmation.validation.exists.FxTenorModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxTenorModel.class)
public class FxTenorModelMeta implements RosettaMetaData<FxTenorModel> {

	@Override
	public List<Validator<? super FxTenorModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxTenorModel>create(fpml.confirmation.validation.datarule.FxTenorModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxTenorModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTenorModel> validator() {
		return new FxTenorModelValidator();
	}

	@Override
	public Validator<? super FxTenorModel> typeFormatValidator() {
		return new FxTenorModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTenorModel, Set<String>> onlyExistsValidator() {
		return new FxTenorModelOnlyExistsValidator();
	}
}
