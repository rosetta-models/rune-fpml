package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ValidationModel;
import fpml.confirmation.validation.ValidationModelTypeFormatValidator;
import fpml.confirmation.validation.ValidationModelValidator;
import fpml.confirmation.validation.exists.ValidationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ValidationModel.class)
public class ValidationModelMeta implements RosettaMetaData<ValidationModel> {

	@Override
	public List<Validator<? super ValidationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ValidationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ValidationModel> validator() {
		return new ValidationModelValidator();
	}

	@Override
	public Validator<? super ValidationModel> typeFormatValidator() {
		return new ValidationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValidationModel, Set<String>> onlyExistsValidator() {
		return new ValidationModelOnlyExistsValidator();
	}
}
