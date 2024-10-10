package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FeaturePayment;
import fpml.confirmation.validation.FeaturePaymentTypeFormatValidator;
import fpml.confirmation.validation.FeaturePaymentValidator;
import fpml.confirmation.validation.exists.FeaturePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FeaturePayment.class)
public class FeaturePaymentMeta implements RosettaMetaData<FeaturePayment> {

	@Override
	public List<Validator<? super FeaturePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FeaturePayment>create(fpml.confirmation.validation.datarule.FeaturePaymentChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FeaturePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FeaturePayment> validator() {
		return new FeaturePaymentValidator();
	}

	@Override
	public Validator<? super FeaturePayment> typeFormatValidator() {
		return new FeaturePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FeaturePayment, Set<String>> onlyExistsValidator() {
		return new FeaturePaymentOnlyExistsValidator();
	}
}
