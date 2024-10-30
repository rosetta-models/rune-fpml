package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.UnitContractModel;
import fpml.confirmation.validation.UnitContractModelTypeFormatValidator;
import fpml.confirmation.validation.UnitContractModelValidator;
import fpml.confirmation.validation.exists.UnitContractModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=UnitContractModel.class)
public class UnitContractModelMeta implements RosettaMetaData<UnitContractModel> {

	@Override
	public List<Validator<? super UnitContractModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UnitContractModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super UnitContractModel> validator() {
		return new UnitContractModelValidator();
	}

	@Override
	public Validator<? super UnitContractModel> typeFormatValidator() {
		return new UnitContractModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UnitContractModel, Set<String>> onlyExistsValidator() {
		return new UnitContractModelOnlyExistsValidator();
	}
}
