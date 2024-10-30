package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetReference;
import fpml.confirmation.validation.FxTargetReferenceTypeFormatValidator;
import fpml.confirmation.validation.FxTargetReferenceValidator;
import fpml.confirmation.validation.exists.FxTargetReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxTargetReference.class)
public class FxTargetReferenceMeta implements RosettaMetaData<FxTargetReference> {

	@Override
	public List<Validator<? super FxTargetReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetReference> validator() {
		return new FxTargetReferenceValidator();
	}

	@Override
	public Validator<? super FxTargetReference> typeFormatValidator() {
		return new FxTargetReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetReference, Set<String>> onlyExistsValidator() {
		return new FxTargetReferenceOnlyExistsValidator();
	}
}
