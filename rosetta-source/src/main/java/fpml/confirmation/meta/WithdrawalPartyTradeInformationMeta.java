package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.WithdrawalPartyTradeInformation;
import fpml.confirmation.validation.WithdrawalPartyTradeInformationTypeFormatValidator;
import fpml.confirmation.validation.WithdrawalPartyTradeInformationValidator;
import fpml.confirmation.validation.exists.WithdrawalPartyTradeInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=WithdrawalPartyTradeInformation.class)
public class WithdrawalPartyTradeInformationMeta implements RosettaMetaData<WithdrawalPartyTradeInformation> {

	@Override
	public List<Validator<? super WithdrawalPartyTradeInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WithdrawalPartyTradeInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super WithdrawalPartyTradeInformation> validator() {
		return new WithdrawalPartyTradeInformationValidator();
	}

	@Override
	public Validator<? super WithdrawalPartyTradeInformation> typeFormatValidator() {
		return new WithdrawalPartyTradeInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WithdrawalPartyTradeInformation, Set<String>> onlyExistsValidator() {
		return new WithdrawalPartyTradeInformationOnlyExistsValidator();
	}
}
