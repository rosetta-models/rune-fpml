package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OptionExerciseAmounts;
import fpml.confirmation.validation.OptionExerciseAmountsTypeFormatValidator;
import fpml.confirmation.validation.OptionExerciseAmountsValidator;
import fpml.confirmation.validation.exists.OptionExerciseAmountsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OptionExerciseAmounts.class)
public class OptionExerciseAmountsMeta implements RosettaMetaData<OptionExerciseAmounts> {

	@Override
	public List<Validator<? super OptionExerciseAmounts>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.OptionExerciseAmounts>create(fpml.confirmation.validation.datarule.OptionExerciseAmountsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OptionExerciseAmounts, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OptionExerciseAmounts> validator() {
		return new OptionExerciseAmountsValidator();
	}

	@Override
	public Validator<? super OptionExerciseAmounts> typeFormatValidator() {
		return new OptionExerciseAmountsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionExerciseAmounts, Set<String>> onlyExistsValidator() {
		return new OptionExerciseAmountsOnlyExistsValidator();
	}
}
