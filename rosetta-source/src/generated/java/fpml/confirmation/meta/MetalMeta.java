package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Metal;
import fpml.confirmation.validation.MetalTypeFormatValidator;
import fpml.confirmation.validation.MetalValidator;
import fpml.confirmation.validation.exists.MetalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Metal.class)
public class MetalMeta implements RosettaMetaData<Metal> {

	@Override
	public List<Validator<? super Metal>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Metal, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Metal> validator() {
		return new MetalValidator();
	}

	@Override
	public Validator<? super Metal> typeFormatValidator() {
		return new MetalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Metal, Set<String>> onlyExistsValidator() {
		return new MetalOnlyExistsValidator();
	}
}
