package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NovationAmountsModel;
import fpml.confirmation.validation.NovationAmountsModelTypeFormatValidator;
import fpml.confirmation.validation.NovationAmountsModelValidator;
import fpml.confirmation.validation.exists.NovationAmountsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NovationAmountsModel.class)
public class NovationAmountsModelMeta implements RosettaMetaData<NovationAmountsModel> {

	@Override
	public List<Validator<? super NovationAmountsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.NovationAmountsModel>create(fpml.confirmation.validation.datarule.NovationAmountsModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super NovationAmountsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NovationAmountsModel> validator() {
		return new NovationAmountsModelValidator();
	}

	@Override
	public Validator<? super NovationAmountsModel> typeFormatValidator() {
		return new NovationAmountsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NovationAmountsModel, Set<String>> onlyExistsValidator() {
		return new NovationAmountsModelOnlyExistsValidator();
	}
}
