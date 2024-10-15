package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Withdrawal;
import fpml.confirmation.validation.WithdrawalTypeFormatValidator;
import fpml.confirmation.validation.WithdrawalValidator;
import fpml.confirmation.validation.exists.WithdrawalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Withdrawal.class)
public class WithdrawalMeta implements RosettaMetaData<Withdrawal> {

	@Override
	public List<Validator<? super Withdrawal>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.Withdrawal>create(fpml.confirmation.validation.datarule.WithdrawalChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Withdrawal, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Withdrawal> validator() {
		return new WithdrawalValidator();
	}

	@Override
	public Validator<? super Withdrawal> typeFormatValidator() {
		return new WithdrawalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Withdrawal, Set<String>> onlyExistsValidator() {
		return new WithdrawalOnlyExistsValidator();
	}
}
