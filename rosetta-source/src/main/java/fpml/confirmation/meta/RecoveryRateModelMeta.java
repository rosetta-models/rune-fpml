package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RecoveryRateModel;
import fpml.confirmation.validation.RecoveryRateModelTypeFormatValidator;
import fpml.confirmation.validation.RecoveryRateModelValidator;
import fpml.confirmation.validation.exists.RecoveryRateModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RecoveryRateModel.class)
public class RecoveryRateModelMeta implements RosettaMetaData<RecoveryRateModel> {

	@Override
	public List<Validator<? super RecoveryRateModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.RecoveryRateModel>create(fpml.confirmation.validation.datarule.RecoveryRateModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RecoveryRateModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RecoveryRateModel> validator() {
		return new RecoveryRateModelValidator();
	}

	@Override
	public Validator<? super RecoveryRateModel> typeFormatValidator() {
		return new RecoveryRateModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RecoveryRateModel, Set<String>> onlyExistsValidator() {
		return new RecoveryRateModelOnlyExistsValidator();
	}
}
