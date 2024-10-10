package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTransfer;
import fpml.confirmation.validation.LoanTransferTypeFormatValidator;
import fpml.confirmation.validation.LoanTransferValidator;
import fpml.confirmation.validation.exists.LoanTransferOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTransfer.class)
public class LoanTransferMeta implements RosettaMetaData<LoanTransfer> {

	@Override
	public List<Validator<? super LoanTransfer>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTransfer, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTransfer> validator() {
		return new LoanTransferValidator();
	}

	@Override
	public Validator<? super LoanTransfer> typeFormatValidator() {
		return new LoanTransferTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTransfer, Set<String>> onlyExistsValidator() {
		return new LoanTransferOnlyExistsValidator();
	}
}
