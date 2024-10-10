package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.StubValue;
import fpml.confirmation.validation.StubValueTypeFormatValidator;
import fpml.confirmation.validation.StubValueValidator;
import fpml.confirmation.validation.exists.StubValueOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=StubValue.class)
public class StubValueMeta implements RosettaMetaData<StubValue> {

	@Override
	public List<Validator<? super StubValue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.StubValue>create(fpml.confirmation.validation.datarule.StubValueChoice.class)
		);
	}
	
	@Override
	public List<Function<? super StubValue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super StubValue> validator() {
		return new StubValueValidator();
	}

	@Override
	public Validator<? super StubValue> typeFormatValidator() {
		return new StubValueTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StubValue, Set<String>> onlyExistsValidator() {
		return new StubValueOnlyExistsValidator();
	}
}
