package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GenericOptionAttributesModel;
import fpml.confirmation.validation.GenericOptionAttributesModelTypeFormatValidator;
import fpml.confirmation.validation.GenericOptionAttributesModelValidator;
import fpml.confirmation.validation.exists.GenericOptionAttributesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GenericOptionAttributesModel.class)
public class GenericOptionAttributesModelMeta implements RosettaMetaData<GenericOptionAttributesModel> {

	@Override
	public List<Validator<? super GenericOptionAttributesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericOptionAttributesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GenericOptionAttributesModel> validator() {
		return new GenericOptionAttributesModelValidator();
	}

	@Override
	public Validator<? super GenericOptionAttributesModel> typeFormatValidator() {
		return new GenericOptionAttributesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericOptionAttributesModel, Set<String>> onlyExistsValidator() {
		return new GenericOptionAttributesModelOnlyExistsValidator();
	}
}
