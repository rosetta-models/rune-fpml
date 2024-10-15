package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DiscountRateModel;
import fpml.confirmation.validation.DiscountRateModelTypeFormatValidator;
import fpml.confirmation.validation.DiscountRateModelValidator;
import fpml.confirmation.validation.exists.DiscountRateModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DiscountRateModel.class)
public class DiscountRateModelMeta implements RosettaMetaData<DiscountRateModel> {

	@Override
	public List<Validator<? super DiscountRateModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DiscountRateModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DiscountRateModel> validator() {
		return new DiscountRateModelValidator();
	}

	@Override
	public Validator<? super DiscountRateModel> typeFormatValidator() {
		return new DiscountRateModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DiscountRateModel, Set<String>> onlyExistsValidator() {
		return new DiscountRateModelOnlyExistsValidator();
	}
}
