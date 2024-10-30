package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RequestConsent;
import fpml.confirmation.validation.RequestConsentTypeFormatValidator;
import fpml.confirmation.validation.RequestConsentValidator;
import fpml.confirmation.validation.exists.RequestConsentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RequestConsent.class)
public class RequestConsentMeta implements RosettaMetaData<RequestConsent> {

	@Override
	public List<Validator<? super RequestConsent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.RequestConsent>create(fpml.confirmation.validation.datarule.RequestConsentChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RequestConsent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RequestConsent> validator() {
		return new RequestConsentValidator();
	}

	@Override
	public Validator<? super RequestConsent> typeFormatValidator() {
		return new RequestConsentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestConsent, Set<String>> onlyExistsValidator() {
		return new RequestConsentOnlyExistsValidator();
	}
}
