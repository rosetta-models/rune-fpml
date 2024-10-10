package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NovationTermsModel;
import fpml.confirmation.validation.NovationTermsModelTypeFormatValidator;
import fpml.confirmation.validation.NovationTermsModelValidator;
import fpml.confirmation.validation.exists.NovationTermsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=NovationTermsModel.class)
public class NovationTermsModelMeta implements RosettaMetaData<NovationTermsModel> {

	@Override
	public List<Validator<? super NovationTermsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NovationTermsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NovationTermsModel> validator() {
		return new NovationTermsModelValidator();
	}

	@Override
	public Validator<? super NovationTermsModel> typeFormatValidator() {
		return new NovationTermsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NovationTermsModel, Set<String>> onlyExistsValidator() {
		return new NovationTermsModelOnlyExistsValidator();
	}
}
