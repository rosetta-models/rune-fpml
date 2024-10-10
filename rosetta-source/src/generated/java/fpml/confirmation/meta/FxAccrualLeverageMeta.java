package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualLeverage;
import fpml.confirmation.validation.FxAccrualLeverageTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualLeverageValidator;
import fpml.confirmation.validation.exists.FxAccrualLeverageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAccrualLeverage.class)
public class FxAccrualLeverageMeta implements RosettaMetaData<FxAccrualLeverage> {

	@Override
	public List<Validator<? super FxAccrualLeverage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxAccrualLeverage>create(fpml.confirmation.validation.datarule.FxAccrualLeverageChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxAccrualLeverage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualLeverage> validator() {
		return new FxAccrualLeverageValidator();
	}

	@Override
	public Validator<? super FxAccrualLeverage> typeFormatValidator() {
		return new FxAccrualLeverageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualLeverage, Set<String>> onlyExistsValidator() {
		return new FxAccrualLeverageOnlyExistsValidator();
	}
}
