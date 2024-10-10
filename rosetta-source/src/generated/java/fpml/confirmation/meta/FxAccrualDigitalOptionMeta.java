package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualDigitalOption;
import fpml.confirmation.validation.FxAccrualDigitalOptionTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualDigitalOptionValidator;
import fpml.confirmation.validation.exists.FxAccrualDigitalOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAccrualDigitalOption.class)
public class FxAccrualDigitalOptionMeta implements RosettaMetaData<FxAccrualDigitalOption> {

	@Override
	public List<Validator<? super FxAccrualDigitalOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualDigitalOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualDigitalOption> validator() {
		return new FxAccrualDigitalOptionValidator();
	}

	@Override
	public Validator<? super FxAccrualDigitalOption> typeFormatValidator() {
		return new FxAccrualDigitalOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualDigitalOption, Set<String>> onlyExistsValidator() {
		return new FxAccrualDigitalOptionOnlyExistsValidator();
	}
}
