package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualTriggerReference;
import fpml.confirmation.validation.FxAccrualTriggerReferenceTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualTriggerReferenceValidator;
import fpml.confirmation.validation.exists.FxAccrualTriggerReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxAccrualTriggerReference.class)
public class FxAccrualTriggerReferenceMeta implements RosettaMetaData<FxAccrualTriggerReference> {

	@Override
	public List<Validator<? super FxAccrualTriggerReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualTriggerReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualTriggerReference> validator() {
		return new FxAccrualTriggerReferenceValidator();
	}

	@Override
	public Validator<? super FxAccrualTriggerReference> typeFormatValidator() {
		return new FxAccrualTriggerReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualTriggerReference, Set<String>> onlyExistsValidator() {
		return new FxAccrualTriggerReferenceOnlyExistsValidator();
	}
}
