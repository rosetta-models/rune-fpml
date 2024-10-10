package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradeSummary;
import fpml.confirmation.validation.LoanTradeSummaryTypeFormatValidator;
import fpml.confirmation.validation.LoanTradeSummaryValidator;
import fpml.confirmation.validation.exists.LoanTradeSummaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTradeSummary.class)
public class LoanTradeSummaryMeta implements RosettaMetaData<LoanTradeSummary> {

	@Override
	public List<Validator<? super LoanTradeSummary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradeSummary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradeSummary> validator() {
		return new LoanTradeSummaryValidator();
	}

	@Override
	public Validator<? super LoanTradeSummary> typeFormatValidator() {
		return new LoanTradeSummaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeSummary, Set<String>> onlyExistsValidator() {
		return new LoanTradeSummaryOnlyExistsValidator();
	}
}
