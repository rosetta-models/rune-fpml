package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPhysicalAmericanExercise;
import fpml.confirmation.validation.CommodityPhysicalAmericanExerciseTypeFormatValidator;
import fpml.confirmation.validation.CommodityPhysicalAmericanExerciseValidator;
import fpml.confirmation.validation.exists.CommodityPhysicalAmericanExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityPhysicalAmericanExercise.class)
public class CommodityPhysicalAmericanExerciseMeta implements RosettaMetaData<CommodityPhysicalAmericanExercise> {

	@Override
	public List<Validator<? super CommodityPhysicalAmericanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityPhysicalAmericanExercise>create(fpml.confirmation.validation.datarule.CommodityPhysicalAmericanExerciseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityPhysicalAmericanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPhysicalAmericanExercise> validator() {
		return new CommodityPhysicalAmericanExerciseValidator();
	}

	@Override
	public Validator<? super CommodityPhysicalAmericanExercise> typeFormatValidator() {
		return new CommodityPhysicalAmericanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPhysicalAmericanExercise, Set<String>> onlyExistsValidator() {
		return new CommodityPhysicalAmericanExerciseOnlyExistsValidator();
	}
}
