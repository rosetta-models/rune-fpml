package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPhysicalExercise;
import fpml.confirmation.validation.CommodityPhysicalExerciseTypeFormatValidator;
import fpml.confirmation.validation.CommodityPhysicalExerciseValidator;
import fpml.confirmation.validation.exists.CommodityPhysicalExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityPhysicalExercise.class)
public class CommodityPhysicalExerciseMeta implements RosettaMetaData<CommodityPhysicalExercise> {

	@Override
	public List<Validator<? super CommodityPhysicalExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityPhysicalExercise>create(fpml.confirmation.validation.datarule.CommodityPhysicalExerciseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityPhysicalExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPhysicalExercise> validator() {
		return new CommodityPhysicalExerciseValidator();
	}

	@Override
	public Validator<? super CommodityPhysicalExercise> typeFormatValidator() {
		return new CommodityPhysicalExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPhysicalExercise, Set<String>> onlyExistsValidator() {
		return new CommodityPhysicalExerciseOnlyExistsValidator();
	}
}
