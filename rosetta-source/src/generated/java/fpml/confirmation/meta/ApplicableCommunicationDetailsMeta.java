package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ApplicableCommunicationDetails;
import fpml.confirmation.validation.ApplicableCommunicationDetailsTypeFormatValidator;
import fpml.confirmation.validation.ApplicableCommunicationDetailsValidator;
import fpml.confirmation.validation.exists.ApplicableCommunicationDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ApplicableCommunicationDetails.class)
public class ApplicableCommunicationDetailsMeta implements RosettaMetaData<ApplicableCommunicationDetails> {

	@Override
	public List<Validator<? super ApplicableCommunicationDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ApplicableCommunicationDetails>create(fpml.confirmation.validation.datarule.ApplicableCommunicationDetailsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ApplicableCommunicationDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ApplicableCommunicationDetails> validator() {
		return new ApplicableCommunicationDetailsValidator();
	}

	@Override
	public Validator<? super ApplicableCommunicationDetails> typeFormatValidator() {
		return new ApplicableCommunicationDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApplicableCommunicationDetails, Set<String>> onlyExistsValidator() {
		return new ApplicableCommunicationDetailsOnlyExistsValidator();
	}
}
