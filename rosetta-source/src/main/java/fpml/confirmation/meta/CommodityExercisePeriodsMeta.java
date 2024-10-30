package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityExercisePeriods;
import fpml.confirmation.validation.CommodityExercisePeriodsTypeFormatValidator;
import fpml.confirmation.validation.CommodityExercisePeriodsValidator;
import fpml.confirmation.validation.exists.CommodityExercisePeriodsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityExercisePeriods.class)
public class CommodityExercisePeriodsMeta implements RosettaMetaData<CommodityExercisePeriods> {

	@Override
	public List<Validator<? super CommodityExercisePeriods>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityExercisePeriods, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityExercisePeriods> validator() {
		return new CommodityExercisePeriodsValidator();
	}

	@Override
	public Validator<? super CommodityExercisePeriods> typeFormatValidator() {
		return new CommodityExercisePeriodsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityExercisePeriods, Set<String>> onlyExistsValidator() {
		return new CommodityExercisePeriodsOnlyExistsValidator();
	}
}
