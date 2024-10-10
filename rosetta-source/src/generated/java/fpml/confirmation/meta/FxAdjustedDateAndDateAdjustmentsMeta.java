package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAdjustedDateAndDateAdjustments;
import fpml.confirmation.validation.FxAdjustedDateAndDateAdjustmentsTypeFormatValidator;
import fpml.confirmation.validation.FxAdjustedDateAndDateAdjustmentsValidator;
import fpml.confirmation.validation.exists.FxAdjustedDateAndDateAdjustmentsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAdjustedDateAndDateAdjustments.class)
public class FxAdjustedDateAndDateAdjustmentsMeta implements RosettaMetaData<FxAdjustedDateAndDateAdjustments> {

	@Override
	public List<Validator<? super FxAdjustedDateAndDateAdjustments>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAdjustedDateAndDateAdjustments, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAdjustedDateAndDateAdjustments> validator() {
		return new FxAdjustedDateAndDateAdjustmentsValidator();
	}

	@Override
	public Validator<? super FxAdjustedDateAndDateAdjustments> typeFormatValidator() {
		return new FxAdjustedDateAndDateAdjustmentsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAdjustedDateAndDateAdjustments, Set<String>> onlyExistsValidator() {
		return new FxAdjustedDateAndDateAdjustmentsOnlyExistsValidator();
	}
}
