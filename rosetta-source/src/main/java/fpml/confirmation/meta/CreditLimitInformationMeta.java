package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditLimitInformation;
import fpml.confirmation.validation.CreditLimitInformationTypeFormatValidator;
import fpml.confirmation.validation.CreditLimitInformationValidator;
import fpml.confirmation.validation.exists.CreditLimitInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CreditLimitInformation.class)
public class CreditLimitInformationMeta implements RosettaMetaData<CreditLimitInformation> {

	@Override
	public List<Validator<? super CreditLimitInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditLimitInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditLimitInformation> validator() {
		return new CreditLimitInformationValidator();
	}

	@Override
	public Validator<? super CreditLimitInformation> typeFormatValidator() {
		return new CreditLimitInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditLimitInformation, Set<String>> onlyExistsValidator() {
		return new CreditLimitInformationOnlyExistsValidator();
	}
}
