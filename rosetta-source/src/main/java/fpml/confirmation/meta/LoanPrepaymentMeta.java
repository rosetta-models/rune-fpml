package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanPrepayment;
import fpml.confirmation.validation.LoanPrepaymentTypeFormatValidator;
import fpml.confirmation.validation.LoanPrepaymentValidator;
import fpml.confirmation.validation.exists.LoanPrepaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanPrepayment.class)
public class LoanPrepaymentMeta implements RosettaMetaData<LoanPrepayment> {

	@Override
	public List<Validator<? super LoanPrepayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanPrepayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanPrepayment> validator() {
		return new LoanPrepaymentValidator();
	}

	@Override
	public Validator<? super LoanPrepayment> typeFormatValidator() {
		return new LoanPrepaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanPrepayment, Set<String>> onlyExistsValidator() {
		return new LoanPrepaymentOnlyExistsValidator();
	}
}
