package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FixedPaymentLeg;
import fpml.confirmation.validation.FixedPaymentLegTypeFormatValidator;
import fpml.confirmation.validation.FixedPaymentLegValidator;
import fpml.confirmation.validation.exists.FixedPaymentLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FixedPaymentLeg.class)
public class FixedPaymentLegMeta implements RosettaMetaData<FixedPaymentLeg> {

	@Override
	public List<Validator<? super FixedPaymentLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FixedPaymentLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FixedPaymentLeg> validator() {
		return new FixedPaymentLegValidator();
	}

	@Override
	public Validator<? super FixedPaymentLeg> typeFormatValidator() {
		return new FixedPaymentLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedPaymentLeg, Set<String>> onlyExistsValidator() {
		return new FixedPaymentLegOnlyExistsValidator();
	}
}
