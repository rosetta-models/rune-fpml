package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AffectedTransactions;
import fpml.confirmation.validation.AffectedTransactionsTypeFormatValidator;
import fpml.confirmation.validation.AffectedTransactionsValidator;
import fpml.confirmation.validation.exists.AffectedTransactionsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AffectedTransactions.class)
public class AffectedTransactionsMeta implements RosettaMetaData<AffectedTransactions> {

	@Override
	public List<Validator<? super AffectedTransactions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AffectedTransactions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AffectedTransactions> validator() {
		return new AffectedTransactionsValidator();
	}

	@Override
	public Validator<? super AffectedTransactions> typeFormatValidator() {
		return new AffectedTransactionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AffectedTransactions, Set<String>> onlyExistsValidator() {
		return new AffectedTransactionsOnlyExistsValidator();
	}
}
