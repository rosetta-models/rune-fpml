package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PeriodicPayment;
import fpml.confirmation.validation.PeriodicPaymentTypeFormatValidator;
import fpml.confirmation.validation.PeriodicPaymentValidator;
import fpml.confirmation.validation.exists.PeriodicPaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PeriodicPayment.class)
public class PeriodicPaymentMeta implements RosettaMetaData<PeriodicPayment> {

	@Override
	public List<Validator<? super PeriodicPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.PeriodicPayment>create(fpml.confirmation.validation.datarule.PeriodicPaymentChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PeriodicPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PeriodicPayment> validator() {
		return new PeriodicPaymentValidator();
	}

	@Override
	public Validator<? super PeriodicPayment> typeFormatValidator() {
		return new PeriodicPaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PeriodicPayment, Set<String>> onlyExistsValidator() {
		return new PeriodicPaymentOnlyExistsValidator();
	}
}
