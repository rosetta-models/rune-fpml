package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ClearingEligibility;
import fpml.confirmation.validation.ClearingEligibilityTypeFormatValidator;
import fpml.confirmation.validation.ClearingEligibilityValidator;
import fpml.confirmation.validation.exists.ClearingEligibilityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ClearingEligibility.class)
public class ClearingEligibilityMeta implements RosettaMetaData<ClearingEligibility> {

	@Override
	public List<Validator<? super ClearingEligibility>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ClearingEligibility>create(fpml.confirmation.validation.datarule.ClearingEligibilityChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ClearingEligibility, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ClearingEligibility> validator() {
		return new ClearingEligibilityValidator();
	}

	@Override
	public Validator<? super ClearingEligibility> typeFormatValidator() {
		return new ClearingEligibilityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingEligibility, Set<String>> onlyExistsValidator() {
		return new ClearingEligibilityOnlyExistsValidator();
	}
}
