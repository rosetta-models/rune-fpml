package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PaymentCalculationPeriod;
import fpml.confirmation.validation.PaymentCalculationPeriodTypeFormatValidator;
import fpml.confirmation.validation.PaymentCalculationPeriodValidator;
import fpml.confirmation.validation.exists.PaymentCalculationPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PaymentCalculationPeriod.class)
public class PaymentCalculationPeriodMeta implements RosettaMetaData<PaymentCalculationPeriod> {

	@Override
	public List<Validator<? super PaymentCalculationPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.PaymentCalculationPeriod>create(fpml.confirmation.validation.datarule.PaymentCalculationPeriodChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PaymentCalculationPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PaymentCalculationPeriod> validator() {
		return new PaymentCalculationPeriodValidator();
	}

	@Override
	public Validator<? super PaymentCalculationPeriod> typeFormatValidator() {
		return new PaymentCalculationPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaymentCalculationPeriod, Set<String>> onlyExistsValidator() {
		return new PaymentCalculationPeriodOnlyExistsValidator();
	}
}
