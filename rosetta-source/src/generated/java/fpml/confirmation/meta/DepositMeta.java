package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Deposit;
import fpml.confirmation.validation.DepositTypeFormatValidator;
import fpml.confirmation.validation.DepositValidator;
import fpml.confirmation.validation.exists.DepositOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Deposit.class)
public class DepositMeta implements RosettaMetaData<Deposit> {

	@Override
	public List<Validator<? super Deposit>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Deposit, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Deposit> validator() {
		return new DepositValidator();
	}

	@Override
	public Validator<? super Deposit> typeFormatValidator() {
		return new DepositTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Deposit, Set<String>> onlyExistsValidator() {
		return new DepositOnlyExistsValidator();
	}
}
