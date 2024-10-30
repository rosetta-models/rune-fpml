package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DaysModel;
import fpml.confirmation.validation.DaysModelTypeFormatValidator;
import fpml.confirmation.validation.DaysModelValidator;
import fpml.confirmation.validation.exists.DaysModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DaysModel.class)
public class DaysModelMeta implements RosettaMetaData<DaysModel> {

	@Override
	public List<Validator<? super DaysModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.DaysModel>create(fpml.confirmation.validation.datarule.DaysModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super DaysModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DaysModel> validator() {
		return new DaysModelValidator();
	}

	@Override
	public Validator<? super DaysModel> typeFormatValidator() {
		return new DaysModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DaysModel, Set<String>> onlyExistsValidator() {
		return new DaysModelOnlyExistsValidator();
	}
}
