package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanBulkServicingNotificationChoice1;
import fpml.confirmation.validation.LoanBulkServicingNotificationChoice1TypeFormatValidator;
import fpml.confirmation.validation.LoanBulkServicingNotificationChoice1Validator;
import fpml.confirmation.validation.exists.LoanBulkServicingNotificationChoice1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanBulkServicingNotificationChoice1.class)
public class LoanBulkServicingNotificationChoice1Meta implements RosettaMetaData<LoanBulkServicingNotificationChoice1> {

	@Override
	public List<Validator<? super LoanBulkServicingNotificationChoice1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.LoanBulkServicingNotificationChoice1>create(fpml.confirmation.validation.datarule.LoanBulkServicingNotificationChoice1Choice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanBulkServicingNotificationChoice1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanBulkServicingNotificationChoice1> validator() {
		return new LoanBulkServicingNotificationChoice1Validator();
	}

	@Override
	public Validator<? super LoanBulkServicingNotificationChoice1> typeFormatValidator() {
		return new LoanBulkServicingNotificationChoice1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanBulkServicingNotificationChoice1, Set<String>> onlyExistsValidator() {
		return new LoanBulkServicingNotificationChoice1OnlyExistsValidator();
	}
}
