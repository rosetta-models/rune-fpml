package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxRateObservableReference;
import fpml.confirmation.validation.FxRateObservableReferenceTypeFormatValidator;
import fpml.confirmation.validation.FxRateObservableReferenceValidator;
import fpml.confirmation.validation.exists.FxRateObservableReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxRateObservableReference.class)
public class FxRateObservableReferenceMeta implements RosettaMetaData<FxRateObservableReference> {

	@Override
	public List<Validator<? super FxRateObservableReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxRateObservableReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxRateObservableReference> validator() {
		return new FxRateObservableReferenceValidator();
	}

	@Override
	public Validator<? super FxRateObservableReference> typeFormatValidator() {
		return new FxRateObservableReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxRateObservableReference, Set<String>> onlyExistsValidator() {
		return new FxRateObservableReferenceOnlyExistsValidator();
	}
}
