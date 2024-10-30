package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SignedInfoType;
import fpml.confirmation.validation.SignedInfoTypeTypeFormatValidator;
import fpml.confirmation.validation.SignedInfoTypeValidator;
import fpml.confirmation.validation.exists.SignedInfoTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SignedInfoType.class)
public class SignedInfoTypeMeta implements RosettaMetaData<SignedInfoType> {

	@Override
	public List<Validator<? super SignedInfoType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SignedInfoType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SignedInfoType> validator() {
		return new SignedInfoTypeValidator();
	}

	@Override
	public Validator<? super SignedInfoType> typeFormatValidator() {
		return new SignedInfoTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SignedInfoType, Set<String>> onlyExistsValidator() {
		return new SignedInfoTypeOnlyExistsValidator();
	}
}
