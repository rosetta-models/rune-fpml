package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTransferFee;
import fpml.confirmation.validation.LoanTransferFeeTypeFormatValidator;
import fpml.confirmation.validation.LoanTransferFeeValidator;
import fpml.confirmation.validation.exists.LoanTransferFeeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTransferFee.class)
public class LoanTransferFeeMeta implements RosettaMetaData<LoanTransferFee> {

	@Override
	public List<Validator<? super LoanTransferFee>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.LoanTransferFee>create(fpml.confirmation.validation.datarule.LoanTransferFeeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanTransferFee, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTransferFee> validator() {
		return new LoanTransferFeeValidator();
	}

	@Override
	public Validator<? super LoanTransferFee> typeFormatValidator() {
		return new LoanTransferFeeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTransferFee, Set<String>> onlyExistsValidator() {
		return new LoanTransferFeeOnlyExistsValidator();
	}
}
