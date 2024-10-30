package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanContractSummary;
import fpml.confirmation.validation.LoanContractSummaryTypeFormatValidator;
import fpml.confirmation.validation.LoanContractSummaryValidator;
import fpml.confirmation.validation.exists.LoanContractSummaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=LoanContractSummary.class)
public class LoanContractSummaryMeta implements RosettaMetaData<LoanContractSummary> {

	@Override
	public List<Validator<? super LoanContractSummary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanContractSummary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanContractSummary> validator() {
		return new LoanContractSummaryValidator();
	}

	@Override
	public Validator<? super LoanContractSummary> typeFormatValidator() {
		return new LoanContractSummaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanContractSummary, Set<String>> onlyExistsValidator() {
		return new LoanContractSummaryOnlyExistsValidator();
	}
}
