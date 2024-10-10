package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdmissionToTrading;
import fpml.confirmation.validation.AdmissionToTradingTypeFormatValidator;
import fpml.confirmation.validation.AdmissionToTradingValidator;
import fpml.confirmation.validation.exists.AdmissionToTradingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AdmissionToTrading.class)
public class AdmissionToTradingMeta implements RosettaMetaData<AdmissionToTrading> {

	@Override
	public List<Validator<? super AdmissionToTrading>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdmissionToTrading, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AdmissionToTrading> validator() {
		return new AdmissionToTradingValidator();
	}

	@Override
	public Validator<? super AdmissionToTrading> typeFormatValidator() {
		return new AdmissionToTradingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdmissionToTrading, Set<String>> onlyExistsValidator() {
		return new AdmissionToTradingOnlyExistsValidator();
	}
}
