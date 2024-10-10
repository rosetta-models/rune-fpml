package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TermDeposit;
import fpml.confirmation.validation.TermDepositTypeFormatValidator;
import fpml.confirmation.validation.TermDepositValidator;
import fpml.confirmation.validation.exists.TermDepositOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TermDeposit.class)
public class TermDepositMeta implements RosettaMetaData<TermDeposit> {

	@Override
	public List<Validator<? super TermDeposit>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TermDeposit, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TermDeposit> validator() {
		return new TermDepositValidator();
	}

	@Override
	public Validator<? super TermDeposit> typeFormatValidator() {
		return new TermDepositTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TermDeposit, Set<String>> onlyExistsValidator() {
		return new TermDepositOnlyExistsValidator();
	}
}
