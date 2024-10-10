package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BasketName;
import fpml.confirmation.validation.BasketNameTypeFormatValidator;
import fpml.confirmation.validation.BasketNameValidator;
import fpml.confirmation.validation.exists.BasketNameOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=BasketName.class)
public class BasketNameMeta implements RosettaMetaData<BasketName> {

	@Override
	public List<Validator<? super BasketName>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BasketName, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BasketName> validator() {
		return new BasketNameValidator();
	}

	@Override
	public Validator<? super BasketName> typeFormatValidator() {
		return new BasketNameTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BasketName, Set<String>> onlyExistsValidator() {
		return new BasketNameOnlyExistsValidator();
	}
}
