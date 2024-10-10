package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetPayoffRegionReference;
import fpml.confirmation.validation.FxTargetPayoffRegionReferenceTypeFormatValidator;
import fpml.confirmation.validation.FxTargetPayoffRegionReferenceValidator;
import fpml.confirmation.validation.exists.FxTargetPayoffRegionReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxTargetPayoffRegionReference.class)
public class FxTargetPayoffRegionReferenceMeta implements RosettaMetaData<FxTargetPayoffRegionReference> {

	@Override
	public List<Validator<? super FxTargetPayoffRegionReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetPayoffRegionReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetPayoffRegionReference> validator() {
		return new FxTargetPayoffRegionReferenceValidator();
	}

	@Override
	public Validator<? super FxTargetPayoffRegionReference> typeFormatValidator() {
		return new FxTargetPayoffRegionReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetPayoffRegionReference, Set<String>> onlyExistsValidator() {
		return new FxTargetPayoffRegionReferenceOnlyExistsValidator();
	}
}
