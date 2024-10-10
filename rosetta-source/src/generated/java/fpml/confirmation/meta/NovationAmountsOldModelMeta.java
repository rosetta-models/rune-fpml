package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NovationAmountsOldModel;
import fpml.confirmation.validation.NovationAmountsOldModelTypeFormatValidator;
import fpml.confirmation.validation.NovationAmountsOldModelValidator;
import fpml.confirmation.validation.exists.NovationAmountsOldModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NovationAmountsOldModel.class)
public class NovationAmountsOldModelMeta implements RosettaMetaData<NovationAmountsOldModel> {

	@Override
	public List<Validator<? super NovationAmountsOldModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.NovationAmountsOldModel>create(fpml.confirmation.validation.datarule.NovationAmountsOldModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super NovationAmountsOldModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NovationAmountsOldModel> validator() {
		return new NovationAmountsOldModelValidator();
	}

	@Override
	public Validator<? super NovationAmountsOldModel> typeFormatValidator() {
		return new NovationAmountsOldModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NovationAmountsOldModel, Set<String>> onlyExistsValidator() {
		return new NovationAmountsOldModelOnlyExistsValidator();
	}
}
