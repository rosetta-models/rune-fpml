package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityLoanContractDetailsModel;
import fpml.confirmation.validation.FacilityLoanContractDetailsModelTypeFormatValidator;
import fpml.confirmation.validation.FacilityLoanContractDetailsModelValidator;
import fpml.confirmation.validation.exists.FacilityLoanContractDetailsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityLoanContractDetailsModel.class)
public class FacilityLoanContractDetailsModelMeta implements RosettaMetaData<FacilityLoanContractDetailsModel> {

	@Override
	public List<Validator<? super FacilityLoanContractDetailsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FacilityLoanContractDetailsModel>create(fpml.confirmation.validation.datarule.FacilityLoanContractDetailsModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FacilityLoanContractDetailsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityLoanContractDetailsModel> validator() {
		return new FacilityLoanContractDetailsModelValidator();
	}

	@Override
	public Validator<? super FacilityLoanContractDetailsModel> typeFormatValidator() {
		return new FacilityLoanContractDetailsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityLoanContractDetailsModel, Set<String>> onlyExistsValidator() {
		return new FacilityLoanContractDetailsModelOnlyExistsValidator();
	}
}
