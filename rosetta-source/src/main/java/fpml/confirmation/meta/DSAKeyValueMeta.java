package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DSAKeyValue;
import fpml.confirmation.validation.DSAKeyValueTypeFormatValidator;
import fpml.confirmation.validation.DSAKeyValueValidator;
import fpml.confirmation.validation.exists.DSAKeyValueOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DSAKeyValue.class)
public class DSAKeyValueMeta implements RosettaMetaData<DSAKeyValue> {

	@Override
	public List<Validator<? super DSAKeyValue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DSAKeyValue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DSAKeyValue> validator() {
		return new DSAKeyValueValidator();
	}

	@Override
	public Validator<? super DSAKeyValue> typeFormatValidator() {
		return new DSAKeyValueTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DSAKeyValue, Set<String>> onlyExistsValidator() {
		return new DSAKeyValueOnlyExistsValidator();
	}
}
