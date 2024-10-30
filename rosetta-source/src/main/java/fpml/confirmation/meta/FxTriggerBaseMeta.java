package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTriggerBase;
import fpml.confirmation.validation.FxTriggerBaseTypeFormatValidator;
import fpml.confirmation.validation.FxTriggerBaseValidator;
import fpml.confirmation.validation.exists.FxTriggerBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxTriggerBase.class)
public class FxTriggerBaseMeta implements RosettaMetaData<FxTriggerBase> {

	@Override
	public List<Validator<? super FxTriggerBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTriggerBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTriggerBase> validator() {
		return new FxTriggerBaseValidator();
	}

	@Override
	public Validator<? super FxTriggerBase> typeFormatValidator() {
		return new FxTriggerBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTriggerBase, Set<String>> onlyExistsValidator() {
		return new FxTriggerBaseOnlyExistsValidator();
	}
}
