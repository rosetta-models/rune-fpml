package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ConsentRefused;
import fpml.confirmation.validation.ConsentRefusedTypeFormatValidator;
import fpml.confirmation.validation.ConsentRefusedValidator;
import fpml.confirmation.validation.exists.ConsentRefusedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ConsentRefused.class)
public class ConsentRefusedMeta implements RosettaMetaData<ConsentRefused> {

	@Override
	public List<Validator<? super ConsentRefused>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ConsentRefused, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ConsentRefused> validator() {
		return new ConsentRefusedValidator();
	}

	@Override
	public Validator<? super ConsentRefused> typeFormatValidator() {
		return new ConsentRefusedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConsentRefused, Set<String>> onlyExistsValidator() {
		return new ConsentRefusedOnlyExistsValidator();
	}
}
