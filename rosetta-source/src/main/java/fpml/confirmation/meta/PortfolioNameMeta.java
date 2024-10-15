package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PortfolioName;
import fpml.confirmation.validation.PortfolioNameTypeFormatValidator;
import fpml.confirmation.validation.PortfolioNameValidator;
import fpml.confirmation.validation.exists.PortfolioNameOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PortfolioName.class)
public class PortfolioNameMeta implements RosettaMetaData<PortfolioName> {

	@Override
	public List<Validator<? super PortfolioName>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PortfolioName, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PortfolioName> validator() {
		return new PortfolioNameValidator();
	}

	@Override
	public Validator<? super PortfolioName> typeFormatValidator() {
		return new PortfolioNameTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PortfolioName, Set<String>> onlyExistsValidator() {
		return new PortfolioNameOnlyExistsValidator();
	}
}
