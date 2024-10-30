package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityExtensionFeePayment;
import fpml.confirmation.validation.FacilityExtensionFeePaymentTypeFormatValidator;
import fpml.confirmation.validation.FacilityExtensionFeePaymentValidator;
import fpml.confirmation.validation.exists.FacilityExtensionFeePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FacilityExtensionFeePayment.class)
public class FacilityExtensionFeePaymentMeta implements RosettaMetaData<FacilityExtensionFeePayment> {

	@Override
	public List<Validator<? super FacilityExtensionFeePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityExtensionFeePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityExtensionFeePayment> validator() {
		return new FacilityExtensionFeePaymentValidator();
	}

	@Override
	public Validator<? super FacilityExtensionFeePayment> typeFormatValidator() {
		return new FacilityExtensionFeePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityExtensionFeePayment, Set<String>> onlyExistsValidator() {
		return new FacilityExtensionFeePaymentOnlyExistsValidator();
	}
}
