package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EntityClassification;
import fpml.confirmation.validation.EntityClassificationTypeFormatValidator;
import fpml.confirmation.validation.EntityClassificationValidator;
import fpml.confirmation.validation.exists.EntityClassificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=EntityClassification.class)
public class EntityClassificationMeta implements RosettaMetaData<EntityClassification> {

	@Override
	public List<Validator<? super EntityClassification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EntityClassification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EntityClassification> validator() {
		return new EntityClassificationValidator();
	}

	@Override
	public Validator<? super EntityClassification> typeFormatValidator() {
		return new EntityClassificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EntityClassification, Set<String>> onlyExistsValidator() {
		return new EntityClassificationOnlyExistsValidator();
	}
}
