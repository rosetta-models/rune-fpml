package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetRegionLowerBound;
import fpml.confirmation.validation.FxTargetRegionLowerBoundTypeFormatValidator;
import fpml.confirmation.validation.FxTargetRegionLowerBoundValidator;
import fpml.confirmation.validation.exists.FxTargetRegionLowerBoundOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxTargetRegionLowerBound.class)
public class FxTargetRegionLowerBoundMeta implements RosettaMetaData<FxTargetRegionLowerBound> {

	@Override
	public List<Validator<? super FxTargetRegionLowerBound>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetRegionLowerBound, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetRegionLowerBound> validator() {
		return new FxTargetRegionLowerBoundValidator();
	}

	@Override
	public Validator<? super FxTargetRegionLowerBound> typeFormatValidator() {
		return new FxTargetRegionLowerBoundTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetRegionLowerBound, Set<String>> onlyExistsValidator() {
		return new FxTargetRegionLowerBoundOnlyExistsValidator();
	}
}
