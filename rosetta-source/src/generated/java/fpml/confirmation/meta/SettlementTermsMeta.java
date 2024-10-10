package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SettlementTerms;
import fpml.confirmation.validation.SettlementTermsTypeFormatValidator;
import fpml.confirmation.validation.SettlementTermsValidator;
import fpml.confirmation.validation.exists.SettlementTermsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SettlementTerms.class)
public class SettlementTermsMeta implements RosettaMetaData<SettlementTerms> {

	@Override
	public List<Validator<? super SettlementTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SettlementTerms> validator() {
		return new SettlementTermsValidator();
	}

	@Override
	public Validator<? super SettlementTerms> typeFormatValidator() {
		return new SettlementTermsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementTerms, Set<String>> onlyExistsValidator() {
		return new SettlementTermsOnlyExistsValidator();
	}
}
