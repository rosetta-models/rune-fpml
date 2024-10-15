package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ClearingEligibilityAcknowledgement;
import fpml.confirmation.validation.ClearingEligibilityAcknowledgementTypeFormatValidator;
import fpml.confirmation.validation.ClearingEligibilityAcknowledgementValidator;
import fpml.confirmation.validation.exists.ClearingEligibilityAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ClearingEligibilityAcknowledgement.class)
public class ClearingEligibilityAcknowledgementMeta implements RosettaMetaData<ClearingEligibilityAcknowledgement> {

	@Override
	public List<Validator<? super ClearingEligibilityAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearingEligibilityAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ClearingEligibilityAcknowledgement> validator() {
		return new ClearingEligibilityAcknowledgementValidator();
	}

	@Override
	public Validator<? super ClearingEligibilityAcknowledgement> typeFormatValidator() {
		return new ClearingEligibilityAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingEligibilityAcknowledgement, Set<String>> onlyExistsValidator() {
		return new ClearingEligibilityAcknowledgementOnlyExistsValidator();
	}
}
