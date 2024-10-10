package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPhysicalEuropeanExercise;
import fpml.confirmation.validation.CommodityPhysicalEuropeanExerciseTypeFormatValidator;
import fpml.confirmation.validation.CommodityPhysicalEuropeanExerciseValidator;
import fpml.confirmation.validation.exists.CommodityPhysicalEuropeanExerciseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityPhysicalEuropeanExercise.class)
public class CommodityPhysicalEuropeanExerciseMeta implements RosettaMetaData<CommodityPhysicalEuropeanExercise> {

	@Override
	public List<Validator<? super CommodityPhysicalEuropeanExercise>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityPhysicalEuropeanExercise>create(fpml.confirmation.validation.datarule.CommodityPhysicalEuropeanExerciseChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityPhysicalEuropeanExercise, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPhysicalEuropeanExercise> validator() {
		return new CommodityPhysicalEuropeanExerciseValidator();
	}

	@Override
	public Validator<? super CommodityPhysicalEuropeanExercise> typeFormatValidator() {
		return new CommodityPhysicalEuropeanExerciseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPhysicalEuropeanExercise, Set<String>> onlyExistsValidator() {
		return new CommodityPhysicalEuropeanExerciseOnlyExistsValidator();
	}
}
