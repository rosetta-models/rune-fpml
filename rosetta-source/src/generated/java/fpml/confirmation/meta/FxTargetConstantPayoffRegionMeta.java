package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetConstantPayoffRegion;
import fpml.confirmation.validation.FxTargetConstantPayoffRegionTypeFormatValidator;
import fpml.confirmation.validation.FxTargetConstantPayoffRegionValidator;
import fpml.confirmation.validation.exists.FxTargetConstantPayoffRegionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxTargetConstantPayoffRegion.class)
public class FxTargetConstantPayoffRegionMeta implements RosettaMetaData<FxTargetConstantPayoffRegion> {

	@Override
	public List<Validator<? super FxTargetConstantPayoffRegion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetConstantPayoffRegion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetConstantPayoffRegion> validator() {
		return new FxTargetConstantPayoffRegionValidator();
	}

	@Override
	public Validator<? super FxTargetConstantPayoffRegion> typeFormatValidator() {
		return new FxTargetConstantPayoffRegionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetConstantPayoffRegion, Set<String>> onlyExistsValidator() {
		return new FxTargetConstantPayoffRegionOnlyExistsValidator();
	}
}
