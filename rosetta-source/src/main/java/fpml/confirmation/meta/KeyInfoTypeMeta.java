package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.KeyInfoType;
import fpml.confirmation.validation.KeyInfoTypeTypeFormatValidator;
import fpml.confirmation.validation.KeyInfoTypeValidator;
import fpml.confirmation.validation.exists.KeyInfoTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=KeyInfoType.class)
public class KeyInfoTypeMeta implements RosettaMetaData<KeyInfoType> {

	@Override
	public List<Validator<? super KeyInfoType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super KeyInfoType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super KeyInfoType> validator() {
		return new KeyInfoTypeValidator();
	}

	@Override
	public Validator<? super KeyInfoType> typeFormatValidator() {
		return new KeyInfoTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super KeyInfoType, Set<String>> onlyExistsValidator() {
		return new KeyInfoTypeOnlyExistsValidator();
	}
}
