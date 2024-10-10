package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PricingParameterShift;
import fpml.confirmation.validation.PricingParameterShiftTypeFormatValidator;
import fpml.confirmation.validation.PricingParameterShiftValidator;
import fpml.confirmation.validation.exists.PricingParameterShiftOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PricingParameterShift.class)
public class PricingParameterShiftMeta implements RosettaMetaData<PricingParameterShift> {

	@Override
	public List<Validator<? super PricingParameterShift>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PricingParameterShift, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PricingParameterShift> validator() {
		return new PricingParameterShiftValidator();
	}

	@Override
	public Validator<? super PricingParameterShift> typeFormatValidator() {
		return new PricingParameterShiftTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingParameterShift, Set<String>> onlyExistsValidator() {
		return new PricingParameterShiftOnlyExistsValidator();
	}
}
