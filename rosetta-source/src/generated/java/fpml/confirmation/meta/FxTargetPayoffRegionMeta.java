package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetPayoffRegion;
import fpml.confirmation.validation.FxTargetPayoffRegionTypeFormatValidator;
import fpml.confirmation.validation.FxTargetPayoffRegionValidator;
import fpml.confirmation.validation.exists.FxTargetPayoffRegionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxTargetPayoffRegion.class)
public class FxTargetPayoffRegionMeta implements RosettaMetaData<FxTargetPayoffRegion> {

	@Override
	public List<Validator<? super FxTargetPayoffRegion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetPayoffRegion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetPayoffRegion> validator() {
		return new FxTargetPayoffRegionValidator();
	}

	@Override
	public Validator<? super FxTargetPayoffRegion> typeFormatValidator() {
		return new FxTargetPayoffRegionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetPayoffRegion, Set<String>> onlyExistsValidator() {
		return new FxTargetPayoffRegionOnlyExistsValidator();
	}
}
