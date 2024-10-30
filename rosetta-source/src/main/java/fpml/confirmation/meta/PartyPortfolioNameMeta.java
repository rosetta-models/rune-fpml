package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyPortfolioName;
import fpml.confirmation.validation.PartyPortfolioNameTypeFormatValidator;
import fpml.confirmation.validation.PartyPortfolioNameValidator;
import fpml.confirmation.validation.exists.PartyPortfolioNameOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PartyPortfolioName.class)
public class PartyPortfolioNameMeta implements RosettaMetaData<PartyPortfolioName> {

	@Override
	public List<Validator<? super PartyPortfolioName>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyPortfolioName, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyPortfolioName> validator() {
		return new PartyPortfolioNameValidator();
	}

	@Override
	public Validator<? super PartyPortfolioName> typeFormatValidator() {
		return new PartyPortfolioNameTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyPortfolioName, Set<String>> onlyExistsValidator() {
		return new PartyPortfolioNameOnlyExistsValidator();
	}
}
