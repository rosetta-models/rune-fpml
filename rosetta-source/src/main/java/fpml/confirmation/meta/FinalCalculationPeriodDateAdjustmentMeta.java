package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FinalCalculationPeriodDateAdjustment;
import fpml.confirmation.validation.FinalCalculationPeriodDateAdjustmentTypeFormatValidator;
import fpml.confirmation.validation.FinalCalculationPeriodDateAdjustmentValidator;
import fpml.confirmation.validation.exists.FinalCalculationPeriodDateAdjustmentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FinalCalculationPeriodDateAdjustment.class)
public class FinalCalculationPeriodDateAdjustmentMeta implements RosettaMetaData<FinalCalculationPeriodDateAdjustment> {

	@Override
	public List<Validator<? super FinalCalculationPeriodDateAdjustment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FinalCalculationPeriodDateAdjustment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FinalCalculationPeriodDateAdjustment> validator() {
		return new FinalCalculationPeriodDateAdjustmentValidator();
	}

	@Override
	public Validator<? super FinalCalculationPeriodDateAdjustment> typeFormatValidator() {
		return new FinalCalculationPeriodDateAdjustmentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FinalCalculationPeriodDateAdjustment, Set<String>> onlyExistsValidator() {
		return new FinalCalculationPeriodDateAdjustmentOnlyExistsValidator();
	}
}
