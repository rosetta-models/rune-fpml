package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualTrigger;
import fpml.confirmation.validation.FxAccrualTriggerTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualTriggerValidator;
import fpml.confirmation.validation.exists.FxAccrualTriggerOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAccrualTrigger.class)
public class FxAccrualTriggerMeta implements RosettaMetaData<FxAccrualTrigger> {

	@Override
	public List<Validator<? super FxAccrualTrigger>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualTrigger, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualTrigger> validator() {
		return new FxAccrualTriggerValidator();
	}

	@Override
	public Validator<? super FxAccrualTrigger> typeFormatValidator() {
		return new FxAccrualTriggerTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualTrigger, Set<String>> onlyExistsValidator() {
		return new FxAccrualTriggerOnlyExistsValidator();
	}
}
