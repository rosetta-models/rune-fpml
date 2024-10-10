package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FloatingRateIndexLoan;
import fpml.confirmation.validation.FloatingRateIndexLoanTypeFormatValidator;
import fpml.confirmation.validation.FloatingRateIndexLoanValidator;
import fpml.confirmation.validation.exists.FloatingRateIndexLoanOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FloatingRateIndexLoan.class)
public class FloatingRateIndexLoanMeta implements RosettaMetaData<FloatingRateIndexLoan> {

	@Override
	public List<Validator<? super FloatingRateIndexLoan>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRateIndexLoan, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FloatingRateIndexLoan> validator() {
		return new FloatingRateIndexLoanValidator();
	}

	@Override
	public Validator<? super FloatingRateIndexLoan> typeFormatValidator() {
		return new FloatingRateIndexLoanTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateIndexLoan, Set<String>> onlyExistsValidator() {
		return new FloatingRateIndexLoanOnlyExistsValidator();
	}
}
