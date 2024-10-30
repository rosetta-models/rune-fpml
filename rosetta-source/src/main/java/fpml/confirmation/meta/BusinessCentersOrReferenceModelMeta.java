package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.validation.BusinessCentersOrReferenceModelTypeFormatValidator;
import fpml.confirmation.validation.BusinessCentersOrReferenceModelValidator;
import fpml.confirmation.validation.exists.BusinessCentersOrReferenceModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=BusinessCentersOrReferenceModel.class)
public class BusinessCentersOrReferenceModelMeta implements RosettaMetaData<BusinessCentersOrReferenceModel> {

	@Override
	public List<Validator<? super BusinessCentersOrReferenceModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.BusinessCentersOrReferenceModel>create(fpml.confirmation.validation.datarule.BusinessCentersOrReferenceModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super BusinessCentersOrReferenceModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BusinessCentersOrReferenceModel> validator() {
		return new BusinessCentersOrReferenceModelValidator();
	}

	@Override
	public Validator<? super BusinessCentersOrReferenceModel> typeFormatValidator() {
		return new BusinessCentersOrReferenceModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessCentersOrReferenceModel, Set<String>> onlyExistsValidator() {
		return new BusinessCentersOrReferenceModelOnlyExistsValidator();
	}
}
