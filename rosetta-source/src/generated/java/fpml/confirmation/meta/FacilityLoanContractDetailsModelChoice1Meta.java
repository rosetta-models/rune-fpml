package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityLoanContractDetailsModelChoice1;
import fpml.confirmation.validation.FacilityLoanContractDetailsModelChoice1TypeFormatValidator;
import fpml.confirmation.validation.FacilityLoanContractDetailsModelChoice1Validator;
import fpml.confirmation.validation.exists.FacilityLoanContractDetailsModelChoice1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityLoanContractDetailsModelChoice1.class)
public class FacilityLoanContractDetailsModelChoice1Meta implements RosettaMetaData<FacilityLoanContractDetailsModelChoice1> {

	@Override
	public List<Validator<? super FacilityLoanContractDetailsModelChoice1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FacilityLoanContractDetailsModelChoice1>create(fpml.confirmation.validation.datarule.FacilityLoanContractDetailsModelChoice1Choice.class)
		);
	}
	
	@Override
	public List<Function<? super FacilityLoanContractDetailsModelChoice1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityLoanContractDetailsModelChoice1> validator() {
		return new FacilityLoanContractDetailsModelChoice1Validator();
	}

	@Override
	public Validator<? super FacilityLoanContractDetailsModelChoice1> typeFormatValidator() {
		return new FacilityLoanContractDetailsModelChoice1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityLoanContractDetailsModelChoice1, Set<String>> onlyExistsValidator() {
		return new FacilityLoanContractDetailsModelChoice1OnlyExistsValidator();
	}
}
