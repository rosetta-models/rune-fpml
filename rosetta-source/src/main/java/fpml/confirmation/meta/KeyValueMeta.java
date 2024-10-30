package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.KeyValue;
import fpml.confirmation.validation.KeyValueTypeFormatValidator;
import fpml.confirmation.validation.KeyValueValidator;
import fpml.confirmation.validation.exists.KeyValueOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=KeyValue.class)
public class KeyValueMeta implements RosettaMetaData<KeyValue> {

	@Override
	public List<Validator<? super KeyValue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.KeyValueType>create(fpml.confirmation.validation.datarule.KeyValueTypeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super KeyValue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super KeyValue> validator() {
		return new KeyValueValidator();
	}

	@Override
	public Validator<? super KeyValue> typeFormatValidator() {
		return new KeyValueTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super KeyValue, Set<String>> onlyExistsValidator() {
		return new KeyValueOnlyExistsValidator();
	}
}
