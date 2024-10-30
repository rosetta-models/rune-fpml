package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessEventPartiesModel;
import fpml.confirmation.validation.BusinessEventPartiesModelTypeFormatValidator;
import fpml.confirmation.validation.BusinessEventPartiesModelValidator;
import fpml.confirmation.validation.exists.BusinessEventPartiesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=BusinessEventPartiesModel.class)
public class BusinessEventPartiesModelMeta implements RosettaMetaData<BusinessEventPartiesModel> {

	@Override
	public List<Validator<? super BusinessEventPartiesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BusinessEventPartiesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BusinessEventPartiesModel> validator() {
		return new BusinessEventPartiesModelValidator();
	}

	@Override
	public Validator<? super BusinessEventPartiesModel> typeFormatValidator() {
		return new BusinessEventPartiesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessEventPartiesModel, Set<String>> onlyExistsValidator() {
		return new BusinessEventPartiesModelOnlyExistsValidator();
	}
}
