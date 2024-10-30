package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DigestMethod;
import fpml.confirmation.validation.DigestMethodTypeFormatValidator;
import fpml.confirmation.validation.DigestMethodValidator;
import fpml.confirmation.validation.exists.DigestMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DigestMethod.class)
public class DigestMethodMeta implements RosettaMetaData<DigestMethod> {

	@Override
	public List<Validator<? super DigestMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DigestMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DigestMethod> validator() {
		return new DigestMethodValidator();
	}

	@Override
	public Validator<? super DigestMethod> typeFormatValidator() {
		return new DigestMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DigestMethod, Set<String>> onlyExistsValidator() {
		return new DigestMethodOnlyExistsValidator();
	}
}
