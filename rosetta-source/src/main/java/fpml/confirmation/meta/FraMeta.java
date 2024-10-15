package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Fra;
import fpml.confirmation.validation.FraTypeFormatValidator;
import fpml.confirmation.validation.FraValidator;
import fpml.confirmation.validation.exists.FraOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Fra.class)
public class FraMeta implements RosettaMetaData<Fra> {

	@Override
	public List<Validator<? super Fra>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Fra, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Fra> validator() {
		return new FraValidator();
	}

	@Override
	public Validator<? super Fra> typeFormatValidator() {
		return new FraTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Fra, Set<String>> onlyExistsValidator() {
		return new FraOnlyExistsValidator();
	}
}
