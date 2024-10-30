package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FixedRecoveryModel;
import fpml.confirmation.validation.FixedRecoveryModelTypeFormatValidator;
import fpml.confirmation.validation.FixedRecoveryModelValidator;
import fpml.confirmation.validation.exists.FixedRecoveryModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FixedRecoveryModel.class)
public class FixedRecoveryModelMeta implements RosettaMetaData<FixedRecoveryModel> {

	@Override
	public List<Validator<? super FixedRecoveryModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FixedRecoveryModel>create(fpml.confirmation.validation.datarule.FixedRecoveryModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FixedRecoveryModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FixedRecoveryModel> validator() {
		return new FixedRecoveryModelValidator();
	}

	@Override
	public Validator<? super FixedRecoveryModel> typeFormatValidator() {
		return new FixedRecoveryModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedRecoveryModel, Set<String>> onlyExistsValidator() {
		return new FixedRecoveryModelOnlyExistsValidator();
	}
}
