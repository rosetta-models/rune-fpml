package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetRegionUpperBound;
import fpml.confirmation.validation.FxTargetRegionUpperBoundTypeFormatValidator;
import fpml.confirmation.validation.FxTargetRegionUpperBoundValidator;
import fpml.confirmation.validation.exists.FxTargetRegionUpperBoundOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxTargetRegionUpperBound.class)
public class FxTargetRegionUpperBoundMeta implements RosettaMetaData<FxTargetRegionUpperBound> {

	@Override
	public List<Validator<? super FxTargetRegionUpperBound>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetRegionUpperBound, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetRegionUpperBound> validator() {
		return new FxTargetRegionUpperBoundValidator();
	}

	@Override
	public Validator<? super FxTargetRegionUpperBound> typeFormatValidator() {
		return new FxTargetRegionUpperBoundTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetRegionUpperBound, Set<String>> onlyExistsValidator() {
		return new FxTargetRegionUpperBoundOnlyExistsValidator();
	}
}
