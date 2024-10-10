package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Object;
import fpml.confirmation.validation.ObjectTypeFormatValidator;
import fpml.confirmation.validation.ObjectValidator;
import fpml.confirmation.validation.exists.ObjectOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Object.class)
public class ObjectMeta implements RosettaMetaData<Object> {

	@Override
	public List<Validator<? super Object>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Object, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Object> validator() {
		return new ObjectValidator();
	}

	@Override
	public Validator<? super Object> typeFormatValidator() {
		return new ObjectTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Object, Set<String>> onlyExistsValidator() {
		return new ObjectOnlyExistsValidator();
	}
}
