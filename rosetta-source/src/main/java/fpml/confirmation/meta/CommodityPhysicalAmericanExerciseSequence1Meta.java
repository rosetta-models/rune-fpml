package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityPhysicalAmericanExerciseSequence1;
import fpml.confirmation.validation.CommodityPhysicalAmericanExerciseSequence1TypeFormatValidator;
import fpml.confirmation.validation.CommodityPhysicalAmericanExerciseSequence1Validator;
import fpml.confirmation.validation.exists.CommodityPhysicalAmericanExerciseSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityPhysicalAmericanExerciseSequence1.class)
public class CommodityPhysicalAmericanExerciseSequence1Meta implements RosettaMetaData<CommodityPhysicalAmericanExerciseSequence1> {

	@Override
	public List<Validator<? super CommodityPhysicalAmericanExerciseSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityPhysicalAmericanExerciseSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityPhysicalAmericanExerciseSequence1> validator() {
		return new CommodityPhysicalAmericanExerciseSequence1Validator();
	}

	@Override
	public Validator<? super CommodityPhysicalAmericanExerciseSequence1> typeFormatValidator() {
		return new CommodityPhysicalAmericanExerciseSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPhysicalAmericanExerciseSequence1, Set<String>> onlyExistsValidator() {
		return new CommodityPhysicalAmericanExerciseSequence1OnlyExistsValidator();
	}
}
