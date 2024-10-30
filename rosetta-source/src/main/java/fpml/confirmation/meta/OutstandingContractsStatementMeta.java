package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OutstandingContractsStatement;
import fpml.confirmation.validation.OutstandingContractsStatementTypeFormatValidator;
import fpml.confirmation.validation.OutstandingContractsStatementValidator;
import fpml.confirmation.validation.exists.OutstandingContractsStatementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OutstandingContractsStatement.class)
public class OutstandingContractsStatementMeta implements RosettaMetaData<OutstandingContractsStatement> {

	@Override
	public List<Validator<? super OutstandingContractsStatement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OutstandingContractsStatement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OutstandingContractsStatement> validator() {
		return new OutstandingContractsStatementValidator();
	}

	@Override
	public Validator<? super OutstandingContractsStatement> typeFormatValidator() {
		return new OutstandingContractsStatementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OutstandingContractsStatement, Set<String>> onlyExistsValidator() {
		return new OutstandingContractsStatementOnlyExistsValidator();
	}
}
