package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanBulkServicingNotificationChoice0;
import fpml.confirmation.validation.LoanBulkServicingNotificationChoice0TypeFormatValidator;
import fpml.confirmation.validation.LoanBulkServicingNotificationChoice0Validator;
import fpml.confirmation.validation.exists.LoanBulkServicingNotificationChoice0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanBulkServicingNotificationChoice0.class)
public class LoanBulkServicingNotificationChoice0Meta implements RosettaMetaData<LoanBulkServicingNotificationChoice0> {

	@Override
	public List<Validator<? super LoanBulkServicingNotificationChoice0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.LoanBulkServicingNotificationChoice0>create(fpml.confirmation.validation.datarule.LoanBulkServicingNotificationChoice0Choice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanBulkServicingNotificationChoice0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanBulkServicingNotificationChoice0> validator() {
		return new LoanBulkServicingNotificationChoice0Validator();
	}

	@Override
	public Validator<? super LoanBulkServicingNotificationChoice0> typeFormatValidator() {
		return new LoanBulkServicingNotificationChoice0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanBulkServicingNotificationChoice0, Set<String>> onlyExistsValidator() {
		return new LoanBulkServicingNotificationChoice0OnlyExistsValidator();
	}
}
