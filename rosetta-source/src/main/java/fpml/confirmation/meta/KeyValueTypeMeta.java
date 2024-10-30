package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.KeyValueType;
import fpml.confirmation.validation.KeyValueTypeTypeFormatValidator;
import fpml.confirmation.validation.KeyValueTypeValidator;
import fpml.confirmation.validation.exists.KeyValueTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=KeyValueType.class)
public class KeyValueTypeMeta implements RosettaMetaData<KeyValueType> {

	@Override
	public List<Validator<? super KeyValueType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.KeyValueType>create(fpml.confirmation.validation.datarule.KeyValueTypeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super KeyValueType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super KeyValueType> validator() {
		return new KeyValueTypeValidator();
	}

	@Override
	public Validator<? super KeyValueType> typeFormatValidator() {
		return new KeyValueTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super KeyValueType, Set<String>> onlyExistsValidator() {
		return new KeyValueTypeOnlyExistsValidator();
	}
}
