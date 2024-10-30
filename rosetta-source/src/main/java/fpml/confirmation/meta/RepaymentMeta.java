package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Repayment;
import fpml.confirmation.validation.RepaymentTypeFormatValidator;
import fpml.confirmation.validation.RepaymentValidator;
import fpml.confirmation.validation.exists.RepaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Repayment.class)
public class RepaymentMeta implements RosettaMetaData<Repayment> {

	@Override
	public List<Validator<? super Repayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Repayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Repayment> validator() {
		return new RepaymentValidator();
	}

	@Override
	public Validator<? super Repayment> typeFormatValidator() {
		return new RepaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Repayment, Set<String>> onlyExistsValidator() {
		return new RepaymentOnlyExistsValidator();
	}
}
