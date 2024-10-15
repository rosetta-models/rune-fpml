package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetLinearPayoffRegion;
import fpml.confirmation.validation.FxTargetLinearPayoffRegionTypeFormatValidator;
import fpml.confirmation.validation.FxTargetLinearPayoffRegionValidator;
import fpml.confirmation.validation.exists.FxTargetLinearPayoffRegionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxTargetLinearPayoffRegion.class)
public class FxTargetLinearPayoffRegionMeta implements RosettaMetaData<FxTargetLinearPayoffRegion> {

	@Override
	public List<Validator<? super FxTargetLinearPayoffRegion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetLinearPayoffRegion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetLinearPayoffRegion> validator() {
		return new FxTargetLinearPayoffRegionValidator();
	}

	@Override
	public Validator<? super FxTargetLinearPayoffRegion> typeFormatValidator() {
		return new FxTargetLinearPayoffRegionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetLinearPayoffRegion, Set<String>> onlyExistsValidator() {
		return new FxTargetLinearPayoffRegionOnlyExistsValidator();
	}
}
