package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RequestConsentRetracted;
import fpml.confirmation.validation.RequestConsentRetractedTypeFormatValidator;
import fpml.confirmation.validation.RequestConsentRetractedValidator;
import fpml.confirmation.validation.exists.RequestConsentRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RequestConsentRetracted.class)
public class RequestConsentRetractedMeta implements RosettaMetaData<RequestConsentRetracted> {

	@Override
	public List<Validator<? super RequestConsentRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.RequestConsentRetracted>create(fpml.confirmation.validation.datarule.RequestConsentRetractedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RequestConsentRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RequestConsentRetracted> validator() {
		return new RequestConsentRetractedValidator();
	}

	@Override
	public Validator<? super RequestConsentRetracted> typeFormatValidator() {
		return new RequestConsentRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestConsentRetracted, Set<String>> onlyExistsValidator() {
		return new RequestConsentRetractedOnlyExistsValidator();
	}
}
