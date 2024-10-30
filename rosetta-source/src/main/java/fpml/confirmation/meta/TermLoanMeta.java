package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TermLoan;
import fpml.confirmation.validation.TermLoanTypeFormatValidator;
import fpml.confirmation.validation.TermLoanValidator;
import fpml.confirmation.validation.exists.TermLoanOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TermLoan.class)
public class TermLoanMeta implements RosettaMetaData<TermLoan> {

	@Override
	public List<Validator<? super TermLoan>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TermLoan, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TermLoan> validator() {
		return new TermLoanValidator();
	}

	@Override
	public Validator<? super TermLoan> typeFormatValidator() {
		return new TermLoanTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TermLoan, Set<String>> onlyExistsValidator() {
		return new TermLoanOnlyExistsValidator();
	}
}
