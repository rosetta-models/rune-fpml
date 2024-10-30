package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxForwardVolatilityAgreement;
import fpml.confirmation.validation.FxForwardVolatilityAgreementTypeFormatValidator;
import fpml.confirmation.validation.FxForwardVolatilityAgreementValidator;
import fpml.confirmation.validation.exists.FxForwardVolatilityAgreementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxForwardVolatilityAgreement.class)
public class FxForwardVolatilityAgreementMeta implements RosettaMetaData<FxForwardVolatilityAgreement> {

	@Override
	public List<Validator<? super FxForwardVolatilityAgreement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxForwardVolatilityAgreement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxForwardVolatilityAgreement> validator() {
		return new FxForwardVolatilityAgreementValidator();
	}

	@Override
	public Validator<? super FxForwardVolatilityAgreement> typeFormatValidator() {
		return new FxForwardVolatilityAgreementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxForwardVolatilityAgreement, Set<String>> onlyExistsValidator() {
		return new FxForwardVolatilityAgreementOnlyExistsValidator();
	}
}
