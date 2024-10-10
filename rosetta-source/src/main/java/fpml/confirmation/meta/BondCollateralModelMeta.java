package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BondCollateralModel;
import fpml.confirmation.validation.BondCollateralModelTypeFormatValidator;
import fpml.confirmation.validation.BondCollateralModelValidator;
import fpml.confirmation.validation.exists.BondCollateralModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=BondCollateralModel.class)
public class BondCollateralModelMeta implements RosettaMetaData<BondCollateralModel> {

	@Override
	public List<Validator<? super BondCollateralModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BondCollateralModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BondCollateralModel> validator() {
		return new BondCollateralModelValidator();
	}

	@Override
	public Validator<? super BondCollateralModel> typeFormatValidator() {
		return new BondCollateralModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BondCollateralModel, Set<String>> onlyExistsValidator() {
		return new BondCollateralModelOnlyExistsValidator();
	}
}
