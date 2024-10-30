package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetAccumulationRegion;
import fpml.confirmation.validation.FxTargetAccumulationRegionTypeFormatValidator;
import fpml.confirmation.validation.FxTargetAccumulationRegionValidator;
import fpml.confirmation.validation.exists.FxTargetAccumulationRegionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxTargetAccumulationRegion.class)
public class FxTargetAccumulationRegionMeta implements RosettaMetaData<FxTargetAccumulationRegion> {

	@Override
	public List<Validator<? super FxTargetAccumulationRegion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetAccumulationRegion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetAccumulationRegion> validator() {
		return new FxTargetAccumulationRegionValidator();
	}

	@Override
	public Validator<? super FxTargetAccumulationRegion> typeFormatValidator() {
		return new FxTargetAccumulationRegionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetAccumulationRegion, Set<String>> onlyExistsValidator() {
		return new FxTargetAccumulationRegionOnlyExistsValidator();
	}
}
