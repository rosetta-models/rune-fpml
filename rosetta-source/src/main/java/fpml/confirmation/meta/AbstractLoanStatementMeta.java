package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractLoanStatement;
import fpml.confirmation.validation.AbstractLoanStatementTypeFormatValidator;
import fpml.confirmation.validation.AbstractLoanStatementValidator;
import fpml.confirmation.validation.exists.AbstractLoanStatementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AbstractLoanStatement.class)
public class AbstractLoanStatementMeta implements RosettaMetaData<AbstractLoanStatement> {

	@Override
	public List<Validator<? super AbstractLoanStatement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanStatement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractLoanStatement> validator() {
		return new AbstractLoanStatementValidator();
	}

	@Override
	public Validator<? super AbstractLoanStatement> typeFormatValidator() {
		return new AbstractLoanStatementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanStatement, Set<String>> onlyExistsValidator() {
		return new AbstractLoanStatementOnlyExistsValidator();
	}
}
