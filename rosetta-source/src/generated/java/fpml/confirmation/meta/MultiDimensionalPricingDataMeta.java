package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MultiDimensionalPricingData;
import fpml.confirmation.validation.MultiDimensionalPricingDataTypeFormatValidator;
import fpml.confirmation.validation.MultiDimensionalPricingDataValidator;
import fpml.confirmation.validation.exists.MultiDimensionalPricingDataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MultiDimensionalPricingData.class)
public class MultiDimensionalPricingDataMeta implements RosettaMetaData<MultiDimensionalPricingData> {

	@Override
	public List<Validator<? super MultiDimensionalPricingData>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MultiDimensionalPricingData, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MultiDimensionalPricingData> validator() {
		return new MultiDimensionalPricingDataValidator();
	}

	@Override
	public Validator<? super MultiDimensionalPricingData> typeFormatValidator() {
		return new MultiDimensionalPricingDataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MultiDimensionalPricingData, Set<String>> onlyExistsValidator() {
		return new MultiDimensionalPricingDataOnlyExistsValidator();
	}
}
