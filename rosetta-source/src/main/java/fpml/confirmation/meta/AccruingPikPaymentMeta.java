package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AccruingPikPayment;
import fpml.confirmation.validation.AccruingPikPaymentTypeFormatValidator;
import fpml.confirmation.validation.AccruingPikPaymentValidator;
import fpml.confirmation.validation.exists.AccruingPikPaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AccruingPikPayment.class)
public class AccruingPikPaymentMeta implements RosettaMetaData<AccruingPikPayment> {

	@Override
	public List<Validator<? super AccruingPikPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccruingPikPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AccruingPikPayment> validator() {
		return new AccruingPikPaymentValidator();
	}

	@Override
	public Validator<? super AccruingPikPayment> typeFormatValidator() {
		return new AccruingPikPaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccruingPikPayment, Set<String>> onlyExistsValidator() {
		return new AccruingPikPaymentOnlyExistsValidator();
	}
}
