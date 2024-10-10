package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualPayoffRegionReference;
import fpml.confirmation.validation.FxAccrualPayoffRegionReferenceTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualPayoffRegionReferenceValidator;
import fpml.confirmation.validation.exists.FxAccrualPayoffRegionReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAccrualPayoffRegionReference.class)
public class FxAccrualPayoffRegionReferenceMeta implements RosettaMetaData<FxAccrualPayoffRegionReference> {

	@Override
	public List<Validator<? super FxAccrualPayoffRegionReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualPayoffRegionReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualPayoffRegionReference> validator() {
		return new FxAccrualPayoffRegionReferenceValidator();
	}

	@Override
	public Validator<? super FxAccrualPayoffRegionReference> typeFormatValidator() {
		return new FxAccrualPayoffRegionReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualPayoffRegionReference, Set<String>> onlyExistsValidator() {
		return new FxAccrualPayoffRegionReferenceOnlyExistsValidator();
	}
}
