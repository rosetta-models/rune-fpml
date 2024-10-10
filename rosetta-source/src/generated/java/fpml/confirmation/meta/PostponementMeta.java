package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Postponement;
import fpml.confirmation.validation.PostponementTypeFormatValidator;
import fpml.confirmation.validation.PostponementValidator;
import fpml.confirmation.validation.exists.PostponementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Postponement.class)
public class PostponementMeta implements RosettaMetaData<Postponement> {

	@Override
	public List<Validator<? super Postponement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Postponement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Postponement> validator() {
		return new PostponementValidator();
	}

	@Override
	public Validator<? super Postponement> typeFormatValidator() {
		return new PostponementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Postponement, Set<String>> onlyExistsValidator() {
		return new PostponementOnlyExistsValidator();
	}
}
