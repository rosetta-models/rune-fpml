package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ConsentGranted;
import fpml.confirmation.validation.ConsentGrantedTypeFormatValidator;
import fpml.confirmation.validation.ConsentGrantedValidator;
import fpml.confirmation.validation.exists.ConsentGrantedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ConsentGranted.class)
public class ConsentGrantedMeta implements RosettaMetaData<ConsentGranted> {

	@Override
	public List<Validator<? super ConsentGranted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ConsentGranted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ConsentGranted> validator() {
		return new ConsentGrantedValidator();
	}

	@Override
	public Validator<? super ConsentGranted> typeFormatValidator() {
		return new ConsentGrantedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConsentGranted, Set<String>> onlyExistsValidator() {
		return new ConsentGrantedOnlyExistsValidator();
	}
}
