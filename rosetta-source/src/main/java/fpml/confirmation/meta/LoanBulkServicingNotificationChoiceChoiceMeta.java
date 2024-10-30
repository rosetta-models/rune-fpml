package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanBulkServicingNotificationChoiceChoice;
import fpml.confirmation.validation.LoanBulkServicingNotificationChoiceChoiceTypeFormatValidator;
import fpml.confirmation.validation.LoanBulkServicingNotificationChoiceChoiceValidator;
import fpml.confirmation.validation.exists.LoanBulkServicingNotificationChoiceChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanBulkServicingNotificationChoiceChoice.class)
public class LoanBulkServicingNotificationChoiceChoiceMeta implements RosettaMetaData<LoanBulkServicingNotificationChoiceChoice> {

	@Override
	public List<Validator<? super LoanBulkServicingNotificationChoiceChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.LoanBulkServicingNotificationChoiceChoice>create(fpml.confirmation.validation.datarule.LoanBulkServicingNotificationChoiceChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanBulkServicingNotificationChoiceChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanBulkServicingNotificationChoiceChoice> validator() {
		return new LoanBulkServicingNotificationChoiceChoiceValidator();
	}

	@Override
	public Validator<? super LoanBulkServicingNotificationChoiceChoice> typeFormatValidator() {
		return new LoanBulkServicingNotificationChoiceChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanBulkServicingNotificationChoiceChoice, Set<String>> onlyExistsValidator() {
		return new LoanBulkServicingNotificationChoiceChoiceOnlyExistsValidator();
	}
}
