package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OutstandingContractsStatementChoice;
import fpml.confirmation.validation.OutstandingContractsStatementChoiceTypeFormatValidator;
import fpml.confirmation.validation.OutstandingContractsStatementChoiceValidator;
import fpml.confirmation.validation.exists.OutstandingContractsStatementChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OutstandingContractsStatementChoice.class)
public class OutstandingContractsStatementChoiceMeta implements RosettaMetaData<OutstandingContractsStatementChoice> {

	@Override
	public List<Validator<? super OutstandingContractsStatementChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.OutstandingContractsStatementChoice>create(fpml.confirmation.validation.datarule.OutstandingContractsStatementChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OutstandingContractsStatementChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OutstandingContractsStatementChoice> validator() {
		return new OutstandingContractsStatementChoiceValidator();
	}

	@Override
	public Validator<? super OutstandingContractsStatementChoice> typeFormatValidator() {
		return new OutstandingContractsStatementChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OutstandingContractsStatementChoice, Set<String>> onlyExistsValidator() {
		return new OutstandingContractsStatementChoiceOnlyExistsValidator();
	}
}
