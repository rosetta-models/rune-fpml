package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityMultipleExercise;
import fpml.confirmation.validation.CommodityMultipleExerciseTypeFormatValidator;
import fpml.confirmation.validation.CommodityMultipleExerciseValidator;
import fpml.confirmation.validation.exists.CommodityMultipleExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityMultipleExercise.class)
public class CommodityMultipleExerciseMeta implements RosettaMetaData<CommodityMultipleExercise> {

	@Override
	public List<Validator<? super CommodityMultipleExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityMultipleExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityMultipleExercise> validator() {
		return new CommodityMultipleExerciseValidator();
	}

	@Override
	public Validator<? super CommodityMultipleExercise> typeFormatValidator() {
		return new CommodityMultipleExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityMultipleExercise, Set<String>> onlyExistsValidator() {
		return new CommodityMultipleExerciseOnlyExistsValidator();
	}
}
