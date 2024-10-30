package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanNotificationAcknowledgement;
import fpml.confirmation.validation.LoanNotificationAcknowledgementTypeFormatValidator;
import fpml.confirmation.validation.LoanNotificationAcknowledgementValidator;
import fpml.confirmation.validation.exists.LoanNotificationAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanNotificationAcknowledgement.class)
public class LoanNotificationAcknowledgementMeta implements RosettaMetaData<LoanNotificationAcknowledgement> {

	@Override
	public List<Validator<? super LoanNotificationAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanNotificationAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanNotificationAcknowledgement> validator() {
		return new LoanNotificationAcknowledgementValidator();
	}

	@Override
	public Validator<? super LoanNotificationAcknowledgement> typeFormatValidator() {
		return new LoanNotificationAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanNotificationAcknowledgement, Set<String>> onlyExistsValidator() {
		return new LoanNotificationAcknowledgementOnlyExistsValidator();
	}
}
