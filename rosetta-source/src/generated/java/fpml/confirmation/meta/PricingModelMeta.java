package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PricingModel;
import fpml.confirmation.validation.PricingModelTypeFormatValidator;
import fpml.confirmation.validation.PricingModelValidator;
import fpml.confirmation.validation.exists.PricingModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PricingModel.class)
public class PricingModelMeta implements RosettaMetaData<PricingModel> {

	@Override
	public List<Validator<? super PricingModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PricingModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PricingModel> validator() {
		return new PricingModelValidator();
	}

	@Override
	public Validator<? super PricingModel> typeFormatValidator() {
		return new PricingModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingModel, Set<String>> onlyExistsValidator() {
		return new PricingModelOnlyExistsValidator();
	}
}
