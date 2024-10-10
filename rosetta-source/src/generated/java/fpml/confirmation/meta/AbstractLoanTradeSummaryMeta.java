package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractLoanTradeSummary;
import fpml.confirmation.validation.AbstractLoanTradeSummaryTypeFormatValidator;
import fpml.confirmation.validation.AbstractLoanTradeSummaryValidator;
import fpml.confirmation.validation.exists.AbstractLoanTradeSummaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AbstractLoanTradeSummary.class)
public class AbstractLoanTradeSummaryMeta implements RosettaMetaData<AbstractLoanTradeSummary> {

	@Override
	public List<Validator<? super AbstractLoanTradeSummary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanTradeSummary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractLoanTradeSummary> validator() {
		return new AbstractLoanTradeSummaryValidator();
	}

	@Override
	public Validator<? super AbstractLoanTradeSummary> typeFormatValidator() {
		return new AbstractLoanTradeSummaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanTradeSummary, Set<String>> onlyExistsValidator() {
		return new AbstractLoanTradeSummaryOnlyExistsValidator();
	}
}
