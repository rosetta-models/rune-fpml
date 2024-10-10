package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetLeverage;
import fpml.confirmation.validation.FxTargetLeverageTypeFormatValidator;
import fpml.confirmation.validation.FxTargetLeverageValidator;
import fpml.confirmation.validation.exists.FxTargetLeverageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxTargetLeverage.class)
public class FxTargetLeverageMeta implements RosettaMetaData<FxTargetLeverage> {

	@Override
	public List<Validator<? super FxTargetLeverage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxTargetLeverage>create(fpml.confirmation.validation.datarule.FxTargetLeverageChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxTargetLeverage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetLeverage> validator() {
		return new FxTargetLeverageValidator();
	}

	@Override
	public Validator<? super FxTargetLeverage> typeFormatValidator() {
		return new FxTargetLeverageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetLeverage, Set<String>> onlyExistsValidator() {
		return new FxTargetLeverageOnlyExistsValidator();
	}
}
