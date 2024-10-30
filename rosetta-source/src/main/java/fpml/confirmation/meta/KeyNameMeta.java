package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.KeyName;
import fpml.confirmation.validation.KeyNameTypeFormatValidator;
import fpml.confirmation.validation.KeyNameValidator;
import fpml.confirmation.validation.exists.KeyNameOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=KeyName.class)
public class KeyNameMeta implements RosettaMetaData<KeyName> {

	@Override
	public List<Validator<? super KeyName>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super KeyName, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super KeyName> validator() {
		return new KeyNameValidator();
	}

	@Override
	public Validator<? super KeyName> typeFormatValidator() {
		return new KeyNameTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super KeyName, Set<String>> onlyExistsValidator() {
		return new KeyNameOnlyExistsValidator();
	}
}
