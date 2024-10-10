package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DigestMethodType;
import fpml.confirmation.validation.DigestMethodTypeTypeFormatValidator;
import fpml.confirmation.validation.DigestMethodTypeValidator;
import fpml.confirmation.validation.exists.DigestMethodTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DigestMethodType.class)
public class DigestMethodTypeMeta implements RosettaMetaData<DigestMethodType> {

	@Override
	public List<Validator<? super DigestMethodType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DigestMethodType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DigestMethodType> validator() {
		return new DigestMethodTypeValidator();
	}

	@Override
	public Validator<? super DigestMethodType> typeFormatValidator() {
		return new DigestMethodTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DigestMethodType, Set<String>> onlyExistsValidator() {
		return new DigestMethodTypeOnlyExistsValidator();
	}
}
