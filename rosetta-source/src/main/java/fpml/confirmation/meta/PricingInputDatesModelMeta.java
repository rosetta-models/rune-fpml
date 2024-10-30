package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PricingInputDatesModel;
import fpml.confirmation.validation.PricingInputDatesModelTypeFormatValidator;
import fpml.confirmation.validation.PricingInputDatesModelValidator;
import fpml.confirmation.validation.exists.PricingInputDatesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PricingInputDatesModel.class)
public class PricingInputDatesModelMeta implements RosettaMetaData<PricingInputDatesModel> {

	@Override
	public List<Validator<? super PricingInputDatesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PricingInputDatesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PricingInputDatesModel> validator() {
		return new PricingInputDatesModelValidator();
	}

	@Override
	public Validator<? super PricingInputDatesModel> typeFormatValidator() {
		return new PricingInputDatesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingInputDatesModel, Set<String>> onlyExistsValidator() {
		return new PricingInputDatesModelOnlyExistsValidator();
	}
}
