package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DSAKeyValueType;
import fpml.confirmation.validation.DSAKeyValueTypeTypeFormatValidator;
import fpml.confirmation.validation.DSAKeyValueTypeValidator;
import fpml.confirmation.validation.exists.DSAKeyValueTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DSAKeyValueType.class)
public class DSAKeyValueTypeMeta implements RosettaMetaData<DSAKeyValueType> {

	@Override
	public List<Validator<? super DSAKeyValueType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DSAKeyValueType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DSAKeyValueType> validator() {
		return new DSAKeyValueTypeValidator();
	}

	@Override
	public Validator<? super DSAKeyValueType> typeFormatValidator() {
		return new DSAKeyValueTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DSAKeyValueType, Set<String>> onlyExistsValidator() {
		return new DSAKeyValueTypeOnlyExistsValidator();
	}
}
