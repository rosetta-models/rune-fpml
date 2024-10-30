package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RSAKeyValue;
import fpml.confirmation.validation.RSAKeyValueTypeFormatValidator;
import fpml.confirmation.validation.RSAKeyValueValidator;
import fpml.confirmation.validation.exists.RSAKeyValueOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RSAKeyValue.class)
public class RSAKeyValueMeta implements RosettaMetaData<RSAKeyValue> {

	@Override
	public List<Validator<? super RSAKeyValue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RSAKeyValue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RSAKeyValue> validator() {
		return new RSAKeyValueValidator();
	}

	@Override
	public Validator<? super RSAKeyValue> typeFormatValidator() {
		return new RSAKeyValueTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RSAKeyValue, Set<String>> onlyExistsValidator() {
		return new RSAKeyValueOnlyExistsValidator();
	}
}
