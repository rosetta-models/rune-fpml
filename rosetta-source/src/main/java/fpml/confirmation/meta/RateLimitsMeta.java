package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RateLimits;
import fpml.confirmation.validation.RateLimitsTypeFormatValidator;
import fpml.confirmation.validation.RateLimitsValidator;
import fpml.confirmation.validation.exists.RateLimitsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RateLimits.class)
public class RateLimitsMeta implements RosettaMetaData<RateLimits> {

	@Override
	public List<Validator<? super RateLimits>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RateLimits, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RateLimits> validator() {
		return new RateLimitsValidator();
	}

	@Override
	public Validator<? super RateLimits> typeFormatValidator() {
		return new RateLimitsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RateLimits, Set<String>> onlyExistsValidator() {
		return new RateLimitsOnlyExistsValidator();
	}
}
