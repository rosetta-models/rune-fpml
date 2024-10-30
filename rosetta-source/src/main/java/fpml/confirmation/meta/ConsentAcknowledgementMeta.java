package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ConsentAcknowledgement;
import fpml.confirmation.validation.ConsentAcknowledgementTypeFormatValidator;
import fpml.confirmation.validation.ConsentAcknowledgementValidator;
import fpml.confirmation.validation.exists.ConsentAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ConsentAcknowledgement.class)
public class ConsentAcknowledgementMeta implements RosettaMetaData<ConsentAcknowledgement> {

	@Override
	public List<Validator<? super ConsentAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ConsentAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ConsentAcknowledgement> validator() {
		return new ConsentAcknowledgementValidator();
	}

	@Override
	public Validator<? super ConsentAcknowledgement> typeFormatValidator() {
		return new ConsentAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConsentAcknowledgement, Set<String>> onlyExistsValidator() {
		return new ConsentAcknowledgementOnlyExistsValidator();
	}
}
