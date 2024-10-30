package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalQualityAdjustments;
import fpml.confirmation.validation.CoalQualityAdjustmentsTypeFormatValidator;
import fpml.confirmation.validation.CoalQualityAdjustmentsValidator;
import fpml.confirmation.validation.exists.CoalQualityAdjustmentsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CoalQualityAdjustments.class)
public class CoalQualityAdjustmentsMeta implements RosettaMetaData<CoalQualityAdjustments> {

	@Override
	public List<Validator<? super CoalQualityAdjustments>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CoalQualityAdjustments, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CoalQualityAdjustments> validator() {
		return new CoalQualityAdjustmentsValidator();
	}

	@Override
	public Validator<? super CoalQualityAdjustments> typeFormatValidator() {
		return new CoalQualityAdjustmentsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalQualityAdjustments, Set<String>> onlyExistsValidator() {
		return new CoalQualityAdjustmentsOnlyExistsValidator();
	}
}
