package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ClearingEligibilityException;
import fpml.confirmation.validation.ClearingEligibilityExceptionTypeFormatValidator;
import fpml.confirmation.validation.ClearingEligibilityExceptionValidator;
import fpml.confirmation.validation.exists.ClearingEligibilityExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ClearingEligibilityException.class)
public class ClearingEligibilityExceptionMeta implements RosettaMetaData<ClearingEligibilityException> {

	@Override
	public List<Validator<? super ClearingEligibilityException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearingEligibilityException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ClearingEligibilityException> validator() {
		return new ClearingEligibilityExceptionValidator();
	}

	@Override
	public Validator<? super ClearingEligibilityException> typeFormatValidator() {
		return new ClearingEligibilityExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingEligibilityException, Set<String>> onlyExistsValidator() {
		return new ClearingEligibilityExceptionOnlyExistsValidator();
	}
}
