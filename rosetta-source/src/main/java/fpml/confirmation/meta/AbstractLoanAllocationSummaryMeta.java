package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AbstractLoanAllocationSummary;
import fpml.confirmation.validation.AbstractLoanAllocationSummaryTypeFormatValidator;
import fpml.confirmation.validation.AbstractLoanAllocationSummaryValidator;
import fpml.confirmation.validation.exists.AbstractLoanAllocationSummaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AbstractLoanAllocationSummary.class)
public class AbstractLoanAllocationSummaryMeta implements RosettaMetaData<AbstractLoanAllocationSummary> {

	@Override
	public List<Validator<? super AbstractLoanAllocationSummary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanAllocationSummary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AbstractLoanAllocationSummary> validator() {
		return new AbstractLoanAllocationSummaryValidator();
	}

	@Override
	public Validator<? super AbstractLoanAllocationSummary> typeFormatValidator() {
		return new AbstractLoanAllocationSummaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanAllocationSummary, Set<String>> onlyExistsValidator() {
		return new AbstractLoanAllocationSummaryOnlyExistsValidator();
	}
}
