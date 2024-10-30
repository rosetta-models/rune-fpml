package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityLoanContractDetailsModelChoice0;
import fpml.confirmation.validation.FacilityLoanContractDetailsModelChoice0TypeFormatValidator;
import fpml.confirmation.validation.FacilityLoanContractDetailsModelChoice0Validator;
import fpml.confirmation.validation.exists.FacilityLoanContractDetailsModelChoice0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FacilityLoanContractDetailsModelChoice0.class)
public class FacilityLoanContractDetailsModelChoice0Meta implements RosettaMetaData<FacilityLoanContractDetailsModelChoice0> {

	@Override
	public List<Validator<? super FacilityLoanContractDetailsModelChoice0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FacilityLoanContractDetailsModelChoice0>create(fpml.confirmation.validation.datarule.FacilityLoanContractDetailsModelChoice0Choice.class)
		);
	}
	
	@Override
	public List<Function<? super FacilityLoanContractDetailsModelChoice0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityLoanContractDetailsModelChoice0> validator() {
		return new FacilityLoanContractDetailsModelChoice0Validator();
	}

	@Override
	public Validator<? super FacilityLoanContractDetailsModelChoice0> typeFormatValidator() {
		return new FacilityLoanContractDetailsModelChoice0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityLoanContractDetailsModelChoice0, Set<String>> onlyExistsValidator() {
		return new FacilityLoanContractDetailsModelChoice0OnlyExistsValidator();
	}
}
