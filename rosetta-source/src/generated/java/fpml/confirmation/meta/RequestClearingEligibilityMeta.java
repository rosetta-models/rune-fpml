package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RequestClearingEligibility;
import fpml.confirmation.validation.RequestClearingEligibilityTypeFormatValidator;
import fpml.confirmation.validation.RequestClearingEligibilityValidator;
import fpml.confirmation.validation.exists.RequestClearingEligibilityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=RequestClearingEligibility.class)
public class RequestClearingEligibilityMeta implements RosettaMetaData<RequestClearingEligibility> {

	@Override
	public List<Validator<? super RequestClearingEligibility>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.RequestClearingEligibility>create(fpml.confirmation.validation.datarule.RequestClearingEligibilityChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RequestClearingEligibility, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RequestClearingEligibility> validator() {
		return new RequestClearingEligibilityValidator();
	}

	@Override
	public Validator<? super RequestClearingEligibility> typeFormatValidator() {
		return new RequestClearingEligibilityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestClearingEligibility, Set<String>> onlyExistsValidator() {
		return new RequestClearingEligibilityOnlyExistsValidator();
	}
}
