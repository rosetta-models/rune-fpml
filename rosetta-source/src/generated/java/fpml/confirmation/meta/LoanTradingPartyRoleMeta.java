package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.LoanTradingPartyRole;
import fpml.confirmation.validation.LoanTradingPartyRoleTypeFormatValidator;
import fpml.confirmation.validation.LoanTradingPartyRoleValidator;
import fpml.confirmation.validation.exists.LoanTradingPartyRoleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LoanTradingPartyRole.class)
public class LoanTradingPartyRoleMeta implements RosettaMetaData<LoanTradingPartyRole> {

	@Override
	public List<Validator<? super LoanTradingPartyRole>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradingPartyRole, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super LoanTradingPartyRole> validator() {
		return new LoanTradingPartyRoleValidator();
	}

	@Override
	public Validator<? super LoanTradingPartyRole> typeFormatValidator() {
		return new LoanTradingPartyRoleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingPartyRole, Set<String>> onlyExistsValidator() {
		return new LoanTradingPartyRoleOnlyExistsValidator();
	}
}
