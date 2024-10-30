package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CanonicalizationMethod;
import fpml.confirmation.validation.CanonicalizationMethodTypeFormatValidator;
import fpml.confirmation.validation.CanonicalizationMethodValidator;
import fpml.confirmation.validation.exists.CanonicalizationMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CanonicalizationMethod.class)
public class CanonicalizationMethodMeta implements RosettaMetaData<CanonicalizationMethod> {

	@Override
	public List<Validator<? super CanonicalizationMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CanonicalizationMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CanonicalizationMethod> validator() {
		return new CanonicalizationMethodValidator();
	}

	@Override
	public Validator<? super CanonicalizationMethod> typeFormatValidator() {
		return new CanonicalizationMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CanonicalizationMethod, Set<String>> onlyExistsValidator() {
		return new CanonicalizationMethodOnlyExistsValidator();
	}
}
