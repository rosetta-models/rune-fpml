package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyEntityClassification;
import fpml.confirmation.validation.PartyEntityClassificationTypeFormatValidator;
import fpml.confirmation.validation.PartyEntityClassificationValidator;
import fpml.confirmation.validation.exists.PartyEntityClassificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PartyEntityClassification.class)
public class PartyEntityClassificationMeta implements RosettaMetaData<PartyEntityClassification> {

	@Override
	public List<Validator<? super PartyEntityClassification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyEntityClassification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyEntityClassification> validator() {
		return new PartyEntityClassificationValidator();
	}

	@Override
	public Validator<? super PartyEntityClassification> typeFormatValidator() {
		return new PartyEntityClassificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyEntityClassification, Set<String>> onlyExistsValidator() {
		return new PartyEntityClassificationOnlyExistsValidator();
	}
}
