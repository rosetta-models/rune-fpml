package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditEventAcknowledgement;
import fpml.confirmation.validation.CreditEventAcknowledgementTypeFormatValidator;
import fpml.confirmation.validation.CreditEventAcknowledgementValidator;
import fpml.confirmation.validation.exists.CreditEventAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CreditEventAcknowledgement.class)
public class CreditEventAcknowledgementMeta implements RosettaMetaData<CreditEventAcknowledgement> {

	@Override
	public List<Validator<? super CreditEventAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditEventAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditEventAcknowledgement> validator() {
		return new CreditEventAcknowledgementValidator();
	}

	@Override
	public Validator<? super CreditEventAcknowledgement> typeFormatValidator() {
		return new CreditEventAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditEventAcknowledgement, Set<String>> onlyExistsValidator() {
		return new CreditEventAcknowledgementOnlyExistsValidator();
	}
}
