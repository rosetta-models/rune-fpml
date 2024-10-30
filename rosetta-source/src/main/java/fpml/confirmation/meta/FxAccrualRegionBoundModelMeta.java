package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualRegionBoundModel;
import fpml.confirmation.validation.FxAccrualRegionBoundModelTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualRegionBoundModelValidator;
import fpml.confirmation.validation.exists.FxAccrualRegionBoundModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxAccrualRegionBoundModel.class)
public class FxAccrualRegionBoundModelMeta implements RosettaMetaData<FxAccrualRegionBoundModel> {

	@Override
	public List<Validator<? super FxAccrualRegionBoundModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxAccrualRegionBoundModel>create(fpml.confirmation.validation.datarule.FxAccrualRegionBoundModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxAccrualRegionBoundModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualRegionBoundModel> validator() {
		return new FxAccrualRegionBoundModelValidator();
	}

	@Override
	public Validator<? super FxAccrualRegionBoundModel> typeFormatValidator() {
		return new FxAccrualRegionBoundModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualRegionBoundModel, Set<String>> onlyExistsValidator() {
		return new FxAccrualRegionBoundModelOnlyExistsValidator();
	}
}
