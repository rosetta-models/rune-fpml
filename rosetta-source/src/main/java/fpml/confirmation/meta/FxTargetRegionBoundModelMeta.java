package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetRegionBoundModel;
import fpml.confirmation.validation.FxTargetRegionBoundModelTypeFormatValidator;
import fpml.confirmation.validation.FxTargetRegionBoundModelValidator;
import fpml.confirmation.validation.exists.FxTargetRegionBoundModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxTargetRegionBoundModel.class)
public class FxTargetRegionBoundModelMeta implements RosettaMetaData<FxTargetRegionBoundModel> {

	@Override
	public List<Validator<? super FxTargetRegionBoundModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxTargetRegionBoundModel>create(fpml.confirmation.validation.datarule.FxTargetRegionBoundModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxTargetRegionBoundModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetRegionBoundModel> validator() {
		return new FxTargetRegionBoundModelValidator();
	}

	@Override
	public Validator<? super FxTargetRegionBoundModel> typeFormatValidator() {
		return new FxTargetRegionBoundModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetRegionBoundModel, Set<String>> onlyExistsValidator() {
		return new FxTargetRegionBoundModelOnlyExistsValidator();
	}
}
