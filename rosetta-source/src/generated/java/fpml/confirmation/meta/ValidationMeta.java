package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Validation;
import fpml.confirmation.validation.ValidationTypeFormatValidator;
import fpml.confirmation.validation.ValidationValidator;
import fpml.confirmation.validation.exists.ValidationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Validation.class)
public class ValidationMeta implements RosettaMetaData<Validation> {

	@Override
	public List<Validator<? super Validation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Validation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Validation> validator() {
		return new ValidationValidator();
	}

	@Override
	public Validator<? super Validation> typeFormatValidator() {
		return new ValidationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Validation, Set<String>> onlyExistsValidator() {
		return new ValidationOnlyExistsValidator();
	}
}
