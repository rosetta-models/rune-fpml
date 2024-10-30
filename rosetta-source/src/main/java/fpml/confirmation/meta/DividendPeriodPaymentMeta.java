package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DividendPeriodPayment;
import fpml.confirmation.validation.DividendPeriodPaymentTypeFormatValidator;
import fpml.confirmation.validation.DividendPeriodPaymentValidator;
import fpml.confirmation.validation.exists.DividendPeriodPaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DividendPeriodPayment.class)
public class DividendPeriodPaymentMeta implements RosettaMetaData<DividendPeriodPayment> {

	@Override
	public List<Validator<? super DividendPeriodPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DividendPeriodPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DividendPeriodPayment> validator() {
		return new DividendPeriodPaymentValidator();
	}

	@Override
	public Validator<? super DividendPeriodPayment> typeFormatValidator() {
		return new DividendPeriodPaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendPeriodPayment, Set<String>> onlyExistsValidator() {
		return new DividendPeriodPaymentOnlyExistsValidator();
	}
}
