package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ClearingAcknowledgement;
import fpml.confirmation.validation.ClearingAcknowledgementTypeFormatValidator;
import fpml.confirmation.validation.ClearingAcknowledgementValidator;
import fpml.confirmation.validation.exists.ClearingAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ClearingAcknowledgement.class)
public class ClearingAcknowledgementMeta implements RosettaMetaData<ClearingAcknowledgement> {

	@Override
	public List<Validator<? super ClearingAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearingAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ClearingAcknowledgement> validator() {
		return new ClearingAcknowledgementValidator();
	}

	@Override
	public Validator<? super ClearingAcknowledgement> typeFormatValidator() {
		return new ClearingAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingAcknowledgement, Set<String>> onlyExistsValidator() {
		return new ClearingAcknowledgementOnlyExistsValidator();
	}
}
