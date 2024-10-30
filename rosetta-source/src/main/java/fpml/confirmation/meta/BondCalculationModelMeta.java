package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BondCalculationModel;
import fpml.confirmation.validation.BondCalculationModelTypeFormatValidator;
import fpml.confirmation.validation.BondCalculationModelValidator;
import fpml.confirmation.validation.exists.BondCalculationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=BondCalculationModel.class)
public class BondCalculationModelMeta implements RosettaMetaData<BondCalculationModel> {

	@Override
	public List<Validator<? super BondCalculationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BondCalculationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BondCalculationModel> validator() {
		return new BondCalculationModelValidator();
	}

	@Override
	public Validator<? super BondCalculationModel> typeFormatValidator() {
		return new BondCalculationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BondCalculationModel, Set<String>> onlyExistsValidator() {
		return new BondCalculationModelOnlyExistsValidator();
	}
}
