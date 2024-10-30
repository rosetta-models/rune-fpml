package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Beneficiary;
import fpml.confirmation.validation.BeneficiaryTypeFormatValidator;
import fpml.confirmation.validation.BeneficiaryValidator;
import fpml.confirmation.validation.exists.BeneficiaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Beneficiary.class)
public class BeneficiaryMeta implements RosettaMetaData<Beneficiary> {

	@Override
	public List<Validator<? super Beneficiary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Beneficiary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Beneficiary> validator() {
		return new BeneficiaryValidator();
	}

	@Override
	public Validator<? super Beneficiary> typeFormatValidator() {
		return new BeneficiaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Beneficiary, Set<String>> onlyExistsValidator() {
		return new BeneficiaryOnlyExistsValidator();
	}
}
